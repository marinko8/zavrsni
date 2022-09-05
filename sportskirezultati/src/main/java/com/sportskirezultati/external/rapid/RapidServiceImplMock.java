package com.sportskirezultati.external.rapid;

import com.sportskirezultati.external.rapid.dto.FixtureResponseDto;
import com.sportskirezultati.external.rapid.dto.LiveOddsResponseDto;
import com.sportskirezultati.external.rapid.dto.OddsResponseDto;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link RapidService}.
 */
@Profile("mock-external")
@Service
@AllArgsConstructor
public class RapidServiceImplMock implements RapidService {

  @Override
  public FixtureResponseDto getFixtureById(Long id) {
    return null;
  }

  @Override
  public FixtureResponseDto getFixtures(LocalDate date) {
    return null;
  }

  @Override
  public FixtureResponseDto getFixtures() {
    return null;
  }

  @Override
  public OddsResponseDto getOddsByDateAndLeague(Integer leagueId, LocalDate date) {
    return null;
  }

  @Override
  public OddsResponseDto getOdds() {
    return null;
  }

  @Override
  public LiveOddsResponseDto getLiveOdds() {
    return null;
  }
}
