package com.sportskirezultati.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BetValueDto {
  private String value;
  private Double odd;
  private String handicap;
  private String main;
  private Boolean suspended;
}
