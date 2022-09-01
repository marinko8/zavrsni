package com.sportskirezultati.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BetValueDto {
  private String value;
  private Double odd;
  private String handicap;
  private String main;
  private Boolean suspended;
}
