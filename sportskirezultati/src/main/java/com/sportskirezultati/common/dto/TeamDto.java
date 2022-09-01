package com.sportskirezultati.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamDto {
  private Integer id;
  private String name;
  private String logo;
  private Boolean winner;
}
