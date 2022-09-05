package com.sportskirezultati.common.dto;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto for bet info.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BetViewDto {

  private Instant betTstamp;

  private Integer betsCount;
  private Integer winningBets;
  private Double totalOdd;
  private Double points;
  private Double pointsToWin;
  private Boolean isActive;
}
