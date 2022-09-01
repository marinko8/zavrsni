package com.sportskirezultati.external.rapid.dto;

import com.sportskirezultati.common.dto.FixtureDto;
import com.sportskirezultati.common.dto.GoalsDto;
import com.sportskirezultati.common.dto.LeagueDto;
import com.sportskirezultati.common.dto.ScoreDto;
import com.sportskirezultati.common.dto.TeamsDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FixtureItemDto {
  private FixtureDto fixture;
  private LeagueDto league;
  private TeamsDto teams;
  private GoalsDto goals;
  private ScoreDto score;
}
