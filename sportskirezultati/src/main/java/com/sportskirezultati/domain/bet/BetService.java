package com.sportskirezultati.domain.bet;

import java.util.List;

/**
 * Service for {@link Bet}.
 */
public interface BetService {

  /**
   * Get by id.
   */
  Bet getById(Long betId);

  /**
   * Get by user id.
   */
  List<Bet> getByUser(Long userId);

  /**
   * Returns all unfinished bets.
   */
  List<Bet> getAllUnfinishedBets();

  /**
   * Save new entity.
   */
  Bet save(Bet bet);

  /**
   * Update entity.
   */
  Bet update(Bet bet);
}
