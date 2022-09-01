package com.sportskirezultati.checkbets.football;

import com.sportskirezultati.domain.betfixtures.BetFixture;

/**
 * Service for checking football bet.
 */
public interface FootballBetCheckService {

  /**
   * Check if football bet is correct.
   */
  void checkFootballFixture(BetFixture betFixture);
}
