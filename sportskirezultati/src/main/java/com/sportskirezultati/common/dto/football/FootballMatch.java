package com.sportskirezultati.common.dto.football;

import com.sportskirezultati.common.dto.BetDto;
import com.sportskirezultati.common.dto.Event;
import com.sportskirezultati.common.dto.GoalsDto;
import com.sportskirezultati.common.dto.LeagueDto;
import com.sportskirezultati.common.dto.StatusDto;
import com.sportskirezultati.common.dto.TeamsDto;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FootballMatch extends Event {

  private LocalDateTime date;
  private TeamsDto teams;
  private LeagueDto league;

  private StatusDto status;
  private Boolean isLive;
  private Boolean isOver;

  private GoalsDto goals;

  private BetDto winnerOdds;
  private List<BetDto> otherOdds;

}
