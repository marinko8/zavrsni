package com.sportskirezultati.external.rapid;

import com.sportskirezultati.config.AppProperties;
import com.sportskirezultati.exception.ExternalException;
import com.sportskirezultati.external.rapid.dto.FixtureResponseDto;
import com.sportskirezultati.external.rapid.dto.LiveOddsItemDto;
import com.sportskirezultati.external.rapid.dto.LiveOddsResponseDto;
import com.sportskirezultati.external.rapid.dto.OddsResponseDto;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/** Implementation of {@link RapidService}. */
@Profile("!mock-external")
@Service
@AllArgsConstructor
public class RapidServiceImpl implements RapidService {

  private final RestTemplate restTemplate;
  private final AppProperties appProperties;

  private static final String FIXTURE_URL = "/fixtures";
  private static final String ODDS_URL = "/odds/";
  private static final String LIVE_ODDS = ODDS_URL + "/live/";

  private static final String DATE_PARAM = "date";
  private static final String ID_PARAM = "id";
  private static final String BET_PARAM = "bet";
  private static final String LEAGUE_PARAM = "league";
  private static final String SEASON_PARAM = "season";

  @Override
  public FixtureResponseDto getFixtureById(Long id) {
    Map<String, String> params = new HashMap<>();
    params.put(ID_PARAM, id.toString());
    return getFixtures(params);
  }

  @Override
  public FixtureResponseDto getFixtures(LocalDate date) {
    Map<String, String> params = new HashMap<>();
    params.put(DATE_PARAM, date.toString());
    return getFixtures(params);
  }

  @Override
  public FixtureResponseDto getFixtures() {
    return getFixtures(Collections.emptyMap());
  }

  private FixtureResponseDto getFixtures(Map<String, String> params) {
    return execute(FIXTURE_URL, params, FixtureResponseDto.class);
  }

  @Override
  public OddsResponseDto getOddsByDateAndLeague(Integer leagueId, LocalDate date) {
    Map<String, String> params = new HashMap<>();
    params.put(DATE_PARAM, date.toString());
    params.put(LEAGUE_PARAM, leagueId.toString());
    params.put(SEASON_PARAM, String.valueOf(date.getYear()));

    return getOdds(params);
  }

  @Override
  public OddsResponseDto getOdds() {
    return getOdds(Collections.emptyMap());
  }

  private OddsResponseDto getOdds(Map<String, String> params) {
    return execute(ODDS_URL, params, OddsResponseDto.class);
  }

  @Override
  public LiveOddsResponseDto getLiveOdds() {
    return execute(LIVE_ODDS, Collections.emptyMap(), LiveOddsResponseDto.class);
  }

  private LiveOddsItemDto getLiveOdds(Map<String, String> params) {
    return execute(LIVE_ODDS, params, LiveOddsItemDto.class);
  }


  private <T> T execute(String url, Map<String, String> params, Class<T> responseClass) {
    try {
      return restTemplate.exchange(getUrl(url, params), HttpMethod.GET,
          getRequest(),
          responseClass, params).getBody();
    } catch (Exception ex) {
      throw new ExternalException("Greška prilikom dohvata podataka iz Rapid servisa!");
    }
  }

  private String getUrl(String url, Map<String, String> params) {
    MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    params.forEach(queryParams::set);

    return UriComponentsBuilder.fromHttpUrl(appProperties.getRapidBaseUrl() + url)
        .queryParams(queryParams).toUriString();
  }

  private HttpEntity<HttpHeaders> getRequest() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

    headers.set("X-RapidAPI-Host", appProperties.getRapidApiHost());
    headers.set("X-RapidAPI-Key", appProperties.getRapidApiKey());

    return new HttpEntity<>(headers);
  }
}
