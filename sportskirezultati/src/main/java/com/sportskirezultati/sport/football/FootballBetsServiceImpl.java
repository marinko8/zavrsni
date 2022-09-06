package com.sportskirezultati.sport.football;

import com.sportskirezultati.common.Constants;
import com.sportskirezultati.common.EventType;
import com.sportskirezultati.common.dto.BusinessResponse;
import com.sportskirezultati.common.dto.EventsDto;
import com.sportskirezultati.common.dto.football.BetGame;
import com.sportskirezultati.common.dto.football.FootballBet;
import com.sportskirezultati.datafetch.football.FetchFootballDataService;
import com.sportskirezultati.domain.bet.Bet;
import com.sportskirezultati.domain.bet.BetService;
import com.sportskirezultati.domain.betfixtures.BetFixture;
import com.sportskirezultati.domain.betfixtures.BetFixtureService;
import com.sportskirezultati.domain.userinfo.UserInfo;
import com.sportskirezultati.domain.userinfo.UserInfoService;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Collections;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link FootballBetsService}.
 */
@Slf4j
@Service
@AllArgsConstructor
public class FootballBetsServiceImpl implements FootballBetsService {

  private final FetchFootballDataService fetchFootballDataService;
  private final BetService betService;
  private final BetFixtureService betFixtureService;
  private final UserInfoService userInfoService;

  @Override
  public EventsDto fetchEventsForDate(LocalDate date) {
    return fetchFootballDataService.fetchFootballMatches(date);
  }

  @Override
  @Transactional
  public BusinessResponse setBet(Long userId, FootballBet bet) {
    Bet domainBet = Bet.builder()
        .userId(userId)
        .points(bet.getPoints())
        .odd(bet.getOdd())
        .prize(bet.getPoints() * bet.getOdd())
        .tstamp(Instant.now()).build();
    betService.save(domainBet);

    saveGames(domainBet.getId(), bet);

    UserInfo userInfo = userInfoService.getByUserId(userId);
    userInfo.setPoints(userInfo.getPoints() - bet.getPoints());
    userInfoService.update(userInfo);

    log.info("Bet {} is saved successfully", domainBet.getId());
    return new BusinessResponse(Collections.emptyList());
  }

  private void saveGames(Long betId, FootballBet bet) {
    for (BetGame game : bet.getGames()) {
      BetFixture betFixture = BetFixture.builder()
          .betId(betId)
          .sportCode(EventType.FOOTBALL.getCode())
          .event(game.getFixtureId())
          .odd(game.getOdd())
          .betType(game.getType())
          .option(game.getValue())
          .build();

      betFixtureService.save(betFixture);
    }
  }
}
