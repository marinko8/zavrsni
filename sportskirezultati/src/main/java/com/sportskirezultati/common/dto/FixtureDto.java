package com.sportskirezultati.common.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FixtureDto {
  private Long id;
  private LocalDateTime date;
  private StatusDto status;
}
