package com.sportskirezultati.domain.bet;

import com.sportskirezultati.common.dto.BetViewDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link Bet}.
 */
@Repository
@Mapper
public interface BetRepository {

  /**
   * Find by id.
   */
  Bet findById(@Param("betId") Long betId);

  /**
   * Find by user id.
   */
  List<Bet> findByUser(@Param("userId") Long userId);

  /**
   * Returns all unfinished bets.
   */
  List<Bet> findAllUnfinishedBets();

  Integer countByUserId(@Param("userId") Long userId);

  Integer countWinnersByUserId(@Param("userId") Long userId);

  List<BetViewDto> getActiveBets(@Param("userId") Long userId);

  List<BetViewDto> getLastFinishedBets(@Param("userId") Long userId,
      @Param("betCount") Integer betCount);

  /**
   * Save new entity.
   */
  long save(Bet bet);

  /**
   * Update entity.
   */
  int update(Bet bet);
}
