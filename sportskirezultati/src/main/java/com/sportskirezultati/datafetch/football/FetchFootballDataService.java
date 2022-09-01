package com.sportskirezultati.datafetch.football;

import com.sportskirezultati.common.dto.EventsDto;
import com.sportskirezultati.external.rapid.dto.FixtureResponseDto;
import java.time.LocalDate;

/**
 * Service for fetching and preparing footballEventsData.
 */
public interface FetchFootballDataService {

  /**
   * Fetch football events for today.
   */
  EventsDto fetchFootballMatches();

  /**
   * Fetch all football matches and their odds.
   *
   * @param date Date of the events
   * @return Dto with list of events info and odds
   */
  EventsDto fetchFootballMatches(LocalDate date);

  /**
   * Fetch football fixture by id.
   */
  FixtureResponseDto fetchFixtureById(Long id);
}
