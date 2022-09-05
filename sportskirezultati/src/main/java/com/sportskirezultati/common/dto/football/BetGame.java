package com.sportskirezultati.common.dto.football;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BetGame {

  private Long fixtureId;
  private String type;
  private Double odd;
  private String value;
}
