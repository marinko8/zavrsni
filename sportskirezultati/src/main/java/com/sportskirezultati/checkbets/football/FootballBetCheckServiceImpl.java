package com.sportskirezultati.checkbets.football;

import com.sportskirezultati.common.Constants;
import com.sportskirezultati.common.dto.GoalsDto;
import com.sportskirezultati.common.dto.football.FootballMatch;
import com.sportskirezultati.datafetch.football.FetchFootballDataService;
import com.sportskirezultati.domain.betfixtures.BetFixture;
import com.sportskirezultati.domain.betfixtures.BetFixtureService;
import com.sportskirezultati.external.rapid.dto.FixtureItemDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link FootballBetCheckService}.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class FootballBetCheckServiceImpl implements FootballBetCheckService {

  private final FetchFootballDataService fetchFootballDataService;
  private final BetFixtureService betFixtureService;

  /**
   * Check if football bet is correct.
   */
  @Override
  public void checkFootballFixture(BetFixture betFixture) {
    List<FootballMatch> matches = (List<FootballMatch>) fetchFootballDataService.fetchFootballMatches()
        .getEvents();

    FootballMatch match = matches.stream()
        .filter(m -> m.getId().equals(betFixture.getEvent()))
        .findAny().orElse(null);

    if (match != null && !match.getIsOver()) {
      return;
    }

    //TODO enable more bet types
    boolean isCorrect = isCorrectWinnerBet(match, betFixture);

    betFixture.setCorrect(isCorrect ? Constants.INDICATOR_YES : Constants.INDICATOR_NO);
    betFixtureService.update(betFixture);
  }

  /**
   * Check if winner bet is correct.
   */
  private boolean isCorrectWinnerBet(FootballMatch match, BetFixture betFixture) {
    if (match != null) {
      return isCorrectWinnerBet(match.getGoals(), betFixture.getOption());
    } else {
      // If match is not in list anymore, find it by id
      FixtureItemDto fixture = fetchFootballDataService.fetchFixtureById(betFixture.getEvent())
          .getResponse().stream().findAny().orElse(null);

      if (fixture == null) {
        return false;
      }

      return isCorrectWinnerBet(fixture.getGoals(), betFixture.getOption());
    }
  }

  /**
   * Check score and returns if bet is correct.
   */
  private boolean isCorrectWinnerBet(GoalsDto goals, String betValue) {
    if (goals.getHome() > goals.getAway()) {
      return Constants.FOOTBALL_WINNER_HOME.equals(betValue);
    } else if (goals.getHome() < goals.getAway()) {
      return Constants.FOOTBALL_WINNER_AWAY.equals(betValue);
    } else {
      return Constants.FOOTBALL_WINNER_DRAW.equals(betValue);
    }
  }
}
