package com.sportskirezultati.domain.betfixtures;

import lombok.Builder;
import lombok.Data;

/**
 * Bet fixture entity.
 */
@Data
@Builder
public class BetFixture {

  private Long id;
  private Long betId;
  private String sportCode;
  private Long event;
  private Double odd;
  private String betType;
  private String option;
  private String correct;
}
