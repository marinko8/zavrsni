package com.sportskirezultati.domain.bet;

import java.time.LocalDateTime;
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
  private Integer points;
  private Double prize;
  private Double odd;
  private String winnerIndicator;
  private LocalDateTime tstamp;
}
