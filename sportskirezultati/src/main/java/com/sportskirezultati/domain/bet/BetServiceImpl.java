package com.sportskirezultati.domain.bet;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link BetService}.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class BetServiceImpl implements BetService {

  private BetRepository repository;

  @Override
  public Bet getById(Long betId) {
    return repository.findById(betId);
  }

  @Override
  public List<Bet> getByUser(Long userId) {
    return repository.findByUser(userId);
  }

  public List<Bet> getAllUnfinishedBets() {
    return repository.findAllUnfinishedBets();
  }


  @Override
  @Transactional
  public Bet save(Bet bet) {
    repository.save(bet);
    log.info("Saved bet with id: {}", bet.getId());
    return bet;
  }

  @Override
  @Transactional
  public Bet update(Bet newEntity) {
    repository.update(newEntity);

    log.info("Updated bet with id: {}", newEntity.getId());

    return newEntity;
  }
}
