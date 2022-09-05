package com.sportskirezultati.datafetch.football;

import com.sportskirezultati.common.Constants;
import com.sportskirezultati.common.EventType;
import com.sportskirezultati.common.dto.BetDto;
import com.sportskirezultati.common.dto.BookmakerDto;
import com.sportskirezultati.common.dto.football.FootballMatch;
import com.sportskirezultati.external.rapid.dto.FixtureItemDto;
import com.sportskirezultati.external.rapid.dto.LiveOddsItemDto;
import com.sportskirezultati.external.rapid.dto.LiveOddsResponseDto;
import com.sportskirezultati.external.rapid.dto.OddsItemDto;
import com.sportskirezultati.external.rapid.dto.OddsResponseDto;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Map api response to events Dto.
 */
public class FootballEventMapper {

  private FootballEventMapper() {
  }

  public static FootballMatch mapToEvent(FixtureItemDto fixture, OddsResponseDto preMatchOdds,
      LiveOddsResponseDto liveOdds) {
    boolean isLive = isLive(fixture);
    boolean isOver = isOver(fixture);

    FootballMatch match = (FootballMatch) FootballMatch.builder()
        .date(fixture.getFixture().getDate())
        .teams(fixture.getTeams())
        .league(fixture.getLeague())
        .status(fixture.getFixture().getStatus())
        .isLive(isLive)
        .isOver(isOver)
        .goals(fixture.getGoals())
        .id(fixture.getFixture().getId())
        .type(EventType.FOOTBALL.getCode()).build();

    if (!isLive && !isOver) {
      // Pre-match odds
      setPreMatchOdds(match, preMatchOdds);
    } else if (isLive) {
      // Live odds
      setLiveOdds(match, liveOdds);
    }

    return match;
  }

  private static boolean isLive(FixtureItemDto fixtureItem) {
    return fixtureItem.getFixture().getDate().isBefore(Instant.now())
        && fixtureItem.getFixture().getStatus().getShortName() != null
        && !Constants.FOOTBALL_STATUS_FT.equals(
        fixtureItem.getFixture().getStatus().getShortName());
  }

  private static boolean isOver(FixtureItemDto fixtureItem) {
    return fixtureItem.getFixture().getDate().isBefore(Instant.now())
        && fixtureItem.getFixture().getStatus().getShortName() != null
        && Constants.FOOTBALL_STATUS_FT.equals(
        fixtureItem.getFixture().getStatus().getShortName());
  }

  private static void setPreMatchOdds(FootballMatch match, OddsResponseDto preMatchOdds) {
    Long fixtureId = match.getId();
    OddsItemDto odds = preMatchOdds.getResponse().stream()
        .filter(o -> o.getFixture().getId().equals(fixtureId)).findAny().orElse(null);

    if (odds == null) {
      return;
    }

    List<BetDto> bets = odds.getBookmakers().stream().findAny().map(BookmakerDto::getBets)
        .orElse(null);

    if (bets == null || bets.isEmpty()) {
      return;
    }

    BetDto winnerOdds = bets.stream()
        .filter(b -> Constants.FOOTBALL_WINNER_BET_ID.equals(b.getId())).findAny().orElse(null);
    match.setWinnerOdds(winnerOdds);

    List<BetDto> otherOdds = bets.stream()
        .filter(b -> !Constants.FOOTBALL_WINNER_BET_ID.equals(b.getId())).collect(
            Collectors.toList());
    match.setOtherOdds(otherOdds);
  }

  private static void setLiveOdds(FootballMatch match, LiveOddsResponseDto liveOdds) {
    Long fixtureId = match.getId();
    LiveOddsItemDto odds = liveOdds.getResponse().stream()
        .filter(o -> o.getFixture().getId().equals(fixtureId)).findAny().orElse(null);

    if (odds == null) {
      return;
    }

    List<BetDto> bets = odds.getOdds();
    if (bets.isEmpty()) {
      return;
    }

    BetDto winnerOdds = bets.stream()
        .filter(b -> Constants.FOOTBALL_LIVE_RESULT_BET_ID.equals(b.getId())).findAny()
        .orElse(null);
    match.setWinnerOdds(winnerOdds);

    List<BetDto> otherOdds = bets.stream()
        .filter(b -> !Constants.FOOTBALL_LIVE_RESULT_BET_ID.equals(b.getId())).collect(
            Collectors.toList());
    match.setOtherOdds(otherOdds);
  }
}
