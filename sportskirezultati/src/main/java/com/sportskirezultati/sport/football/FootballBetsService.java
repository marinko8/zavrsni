package com.sportskirezultati.sport.football;

import com.sportskirezultati.common.dto.BusinessResponse;
import com.sportskirezultati.common.dto.EventsDto;
import com.sportskirezultati.common.dto.football.FootballBet;
import java.time.LocalDate;

/**
 * Service for fetching football data.
 */
public interface FootballBetsService {

  /**
   * Fetch data for a date.
   */
  public EventsDto fetchEventsForDate(LocalDate date);

  /**
   * Set new bet.
   */
  public BusinessResponse setBet(Long userId, FootballBet bet);
}
