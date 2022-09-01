package com.sportskirezultati.checkbets;

import com.sportskirezultati.checkbets.football.FootballBetCheckService;
import com.sportskirezultati.common.Constants;
import com.sportskirezultati.config.AppProperties;
import com.sportskirezultati.domain.bet.Bet;
import com.sportskirezultati.domain.bet.BetService;
import com.sportskirezultati.domain.betfixtures.BetFixture;
import com.sportskirezultati.domain.betfixtures.BetFixtureService;
import com.sportskirezultati.domain.userinfo.UserInfo;
import com.sportskirezultati.domain.userinfo.UserInfoService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link BetsCheckService}.
 */
@Slf4j
@Service
@AllArgsConstructor
public class BetCheckServiceImpl implements BetsCheckService {

  private final BetFixtureService betFixtureService;
  private final BetService betService;
  private final UserInfoService userInfoService;
  private final AppProperties appProperties;
  private final FootballBetCheckService footballBetCheckService;

  @Override
  @Transactional
  public void checkBet(Bet bet) {
    List<BetFixture> fixtures = betFixtureService.getByBetId(bet.getId());

    for (BetFixture fixture : fixtures) {
      //TODO enable more sports
      footballBetCheckService.checkFootballFixture(fixture);

      if (Constants.INDICATOR_NO.equals(fixture.getCorrect())) {
        updateBetWinnerIndicator(bet, Constants.INDICATOR_NO);
      }
    }

    if (fixtures.stream().allMatch(f -> Constants.INDICATOR_YES.equals(f.getCorrect()))) {
      updateBetWinnerIndicator(bet, Constants.INDICATOR_YES);
    }
  }

  private void updateBetWinnerIndicator(Bet bet, String indicator) {
    bet.setWinnerIndicator(indicator);
    betService.update(bet);

    updateUserInfo(bet);
  }

  private void updateUserInfo(Bet bet) {
    UserInfo userInfo = userInfoService.getByUserId(bet.getUserId());
    Double betPoints = bet.getPoints() * bet.getOdd();

    if (Constants.INDICATOR_YES.equals(bet.getWinnerIndicator())) {
      // Add points if bet is winner
      userInfo.setPoints(userInfo.getPoints() + betPoints);
    } else if ((userInfo.getPoints() - betPoints) < appProperties.getMinimalBet()) {
      // Bankrupt
      userInfo.setPoints(appProperties.getBasePoints());
      userInfo.setBankruptTimes(userInfo.getBankruptTimes() + 1);
    } else {
      // Subtract points
      userInfo.setPoints(userInfo.getPoints() - betPoints);
    }

    userInfoService.update(userInfo);
  }
}
