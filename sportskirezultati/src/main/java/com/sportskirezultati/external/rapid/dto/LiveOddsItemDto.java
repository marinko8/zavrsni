package com.sportskirezultati.external.rapid.dto;

import com.sportskirezultati.common.dto.BetDto;
import com.sportskirezultati.common.dto.FixtureDto;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LiveOddsItemDto {
  private FixtureDto fixture;
  private LocalDateTime update;
  private List<BetDto> odds;
}
