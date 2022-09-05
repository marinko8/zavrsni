package com.sportskirezultati.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto {
  private Integer id;
  private String name;
  private String logo;
  private Boolean winner;
}
