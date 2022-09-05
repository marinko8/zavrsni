package com.sportskirezultati.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeagueDto {
  private Integer id;
  private String name;
  private String country;
  private String logo;
  private String flag;
  private Integer season;
}
