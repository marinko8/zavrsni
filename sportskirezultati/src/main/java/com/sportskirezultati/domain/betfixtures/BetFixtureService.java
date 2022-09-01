package com.sportskirezultati.domain.betfixtures;

import java.util.List;

/**
 * Service for {@link BetFixture}.
 */
public interface BetFixtureService {

  /**
   * Get by id.
   */
  BetFixture getById(Long betFixtureId);

  /**
   * Get by bet id.
   */
  List<BetFixture> getByBetId(Long betId);

  /**
   * Save new entity.
   */
  BetFixture save(BetFixture betFixture);

  /**
   * Update entity.
   */
  BetFixture update(BetFixture betFixture);

  /**
   * Delete entity.
   */
  void delete(Long betFixtureId);

  /**
   * Delete all for bet id.
   */
  void deleteByBetId(Long betId);
}
