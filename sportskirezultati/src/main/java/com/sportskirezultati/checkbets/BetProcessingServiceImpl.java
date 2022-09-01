package com.sportskirezultati.checkbets;

import com.sportskirezultati.domain.bet.Bet;
import com.sportskirezultati.domain.bet.BetService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link BetProcessingService}.
 */
@Slf4j
@Service
@AllArgsConstructor
public class BetProcessingServiceImpl implements BetProcessingService {

  private final BetService betService;
  private final BetsCheckService betsCheckService;

  @Scheduled(cron = "#{appProperties.betCheckCron}")
  @Override
  public void processBetChecking() {
    List<Bet> unfinishedBets = betService.getAllUnfinishedBets();

    unfinishedBets.forEach(betsCheckService::checkBet);
  }
}
