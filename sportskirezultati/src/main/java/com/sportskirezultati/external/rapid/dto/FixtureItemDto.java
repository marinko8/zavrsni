package com.sportskirezultati.external.rapid.dto;

import com.sportskirezultati.common.dto.FixtureDto;
import com.sportskirezultati.common.dto.GoalsDto;
import com.sportskirezultati.common.dto.LeagueDto;
import com.sportskirezultati.common.dto.ScoreDto;
import com.sportskirezultati.common.dto.TeamsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FixtureItemDto {
  private FixtureDto fixture;
  private LeagueDto league;
  private TeamsDto teams;
  private GoalsDto goals;
  private ScoreDto score;
}
