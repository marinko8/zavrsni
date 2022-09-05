package com.sportskirezultati.domain.bet;

import com.sportskirezultati.common.dto.BetViewDto;
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

  private final BetRepository repository;

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
  public Integer countByUserId(Long userId) {
    return repository.countByUserId(userId);
  }

  @Override
  public Integer countWinnersByUserId(Long userId) {
    return repository.countWinnersByUserId(userId);
  }

  @Override
  public List<BetViewDto> getActiveBets(Long userId) {
    return repository.getActiveBets(userId);
  }

  @Override
  public List<BetViewDto> getLastFinishedBets(Long userId, Integer betCount) {
    return repository.getLastFinishedBets(userId, betCount);
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
