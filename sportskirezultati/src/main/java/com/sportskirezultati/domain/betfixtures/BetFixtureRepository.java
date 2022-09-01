package com.sportskirezultati.domain.betfixtures;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link BetFixture}.
 */
@Repository
@Mapper
public interface BetFixtureRepository {

  /**
   * Find by id.
   */
  BetFixture findById(@Param("betFixtureId") Long betFixtureId);

  /**
   * Find by bet id.
   */
  List<BetFixture> findByBetId(@Param("betId") Long betId);

  /**
   * Save new entity.
   */
  long save(BetFixture betFixture);

  /**
   * Update entity.
   */
  int update(BetFixture betFixture);

  /**
   * Delete entity.
   */
  int delete(@Param("betFixtureId") Long betFixtureId);

  /**
   * Delete all for bet id.
   */
  int deleteByBetId(@Param("betId") Long betId);
}
