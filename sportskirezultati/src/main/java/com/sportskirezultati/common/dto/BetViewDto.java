package com.sportskirezultati.common.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 * Dto for bet info.
 */
@Data
@Builder
public class BetViewDto {

  private LocalDateTime betTstamp;

  private Integer numberOfGames;
  private Integer wonGames;

  private boolean active;
  private boolean failed;
}
