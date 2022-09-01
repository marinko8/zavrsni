package com.sportskirezultati.external.rapid;

import com.sportskirezultati.external.rapid.dto.FixtureResponseDto;
import com.sportskirezultati.external.rapid.dto.LiveOddsResponseDto;
import com.sportskirezultati.external.rapid.dto.OddsResponseDto;
import java.time.LocalDate;

public interface RapidService {

  FixtureResponseDto getFixtureById(Long id);

  FixtureResponseDto getFixtures(LocalDate date);

  OddsResponseDto getOddsByDate(LocalDate date);

  LiveOddsResponseDto getLiveOdds();

  OddsResponseDto getOdds();

  FixtureResponseDto getFixtures();
}
