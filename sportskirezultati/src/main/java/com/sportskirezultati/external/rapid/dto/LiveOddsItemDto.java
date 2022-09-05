package com.sportskirezultati.external.rapid.dto;

import com.sportskirezultati.common.dto.BetDto;
import com.sportskirezultati.common.dto.FixtureDto;
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
public class LiveOddsItemDto {
  private FixtureDto fixture;
  private Instant update;
  private List<BetDto> odds;
}
