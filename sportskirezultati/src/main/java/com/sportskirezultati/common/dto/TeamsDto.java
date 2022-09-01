package com.sportskirezultati.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamsDto {
  private TeamDto home;
  private TeamDto away;
}
