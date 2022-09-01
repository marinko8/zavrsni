package com.sportskirezultati.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LeagueDto {
  private Integer id;
  private String name;
  private String county;
  private String logo;
  private String flag;
  private Integer season;
}
