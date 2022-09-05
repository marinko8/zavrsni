package com.sportskirezultati.domain.bet;

import java.time.Instant;
import lombok.Builder;
import lombok.Data;

/**
 * Bet entity.
 */
@Data
@Builder
public class Bet {

  private Long id;
  private Long userId;
  private Double points;
  private Double prize;
  private Double odd;
  private String winnerIndicator;
  private Instant tstamp;
}
