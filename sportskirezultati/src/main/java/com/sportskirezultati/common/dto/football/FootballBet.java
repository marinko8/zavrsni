package com.sportskirezultati.common.dto.football;

import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FootballBet {
  private List<BetGame> games;
  private Double odd;
  private Double points;
}
