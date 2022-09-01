package com.sportskirezultati.domain.betfixtures;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link BetFixtureService}.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class BetFixtureServiceImpl implements BetFixtureService {

  private BetFixtureRepository repository;

  @Override
  public BetFixture getById(Long betFixtureId) {
    return null;
  }

  @Override
  public List<BetFixture> getByBetId(Long betId) {
    return null;
  }

  @Override
  @Transactional
  public BetFixture save(BetFixture betFixture) {
    repository.save(betFixture);
    log.info("Saved bet fixture with id: {}", betFixture.getId());
    return betFixture;
  }

  @Override
  @Transactional
  public BetFixture update(BetFixture newEntity) {
    repository.update(newEntity);

    log.info("Updated bet fixture with id: {}", newEntity.getId());

    return newEntity;
  }

  @Override
  @Transactional
  public void delete(Long betFixtureId) {
    repository.delete(betFixtureId);
    log.info("Deleted bet fixture with id: {}", betFixtureId);
  }

  @Override
  @Transactional
  public void deleteByBetId(Long betId) {
    repository.deleteByBetId(betId);
    log.info("Deleted bet fixtures with bet id: {}", betId);
  }
}
