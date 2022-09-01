package com.sportskirezultati.checkbets;

import com.sportskirezultati.domain.bet.Bet;

/**
 * Service for bet checking.
 */
public interface BetsCheckService {

  /**
   * Check all bet fixtures.
   */
  void checkBet(Bet bet);
}
