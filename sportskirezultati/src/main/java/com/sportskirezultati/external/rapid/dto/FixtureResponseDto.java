package com.sportskirezultati.external.rapid.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FixtureResponseDto extends RapidResponse {
  private List<FixtureItemDto> response;
}
