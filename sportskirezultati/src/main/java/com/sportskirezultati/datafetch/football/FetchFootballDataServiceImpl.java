package com.sportskirezultati.datafetch.football;

import com.sportskirezultati.common.dto.EventsDto;
import com.sportskirezultati.common.dto.football.FootballMatch;
import com.sportskirezultati.config.AppProperties;
import com.sportskirezultati.external.rapid.RapidService;
import com.sportskirezultati.external.rapid.dto.FixtureResponseDto;
import com.sportskirezultati.external.rapid.dto.LiveOddsResponseDto;
import com.sportskirezultati.external.rapid.dto.OddsResponseDto;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link FetchFootballDataService}.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class FetchFootballDataServiceImpl implements FetchFootballDataService {

  private final RapidService rapidService;
  private final AppProperties appProperties;

  @Cacheable("footballMatchesToday")
  @Override
  public EventsDto fetchFootballMatches() {
    return fetchFootballMatches(LocalDate.now());
  }

  @Override
  public EventsDto fetchFootballMatches(LocalDate date) {
    FixtureResponseDto fixtures = rapidService.getFixtures(date);
    OddsResponseDto preMatchOdds = rapidService.getOddsByDate(date);
    LiveOddsResponseDto liveOdds = rapidService.getLiveOdds();

    List<FootballMatch> events = fixtures.getResponse().stream()
        .filter(f -> appProperties.getSupportedLeagues().contains(f.getLeague().getId()))
        .map(f -> FootballEventMapper.mapToEvent(f, preMatchOdds, liveOdds)).collect(
            Collectors.toList());

    return EventsDto.builder().events(events).build();
  }

  @Override
  public FixtureResponseDto fetchFixtureById(Long id) {
    return rapidService.getFixtureById(id);
  }
}
