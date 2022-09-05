package com.sportskirezultati.domain.bet;

import com.sportskirezultati.common.dto.BetViewDto;
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

  Integer countByUserId(Long userId);

  Integer countWinnersByUserId(Long userId);

  List<BetViewDto> getActiveBets(Long userId);

  List<BetViewDto> getLastFinishedBets(Long userId, Integer betCount);

  /**
   * Save new entity.
   */
  Bet save(Bet bet);

  /**
   * Update entity.
   */
  Bet update(Bet bet);
}
