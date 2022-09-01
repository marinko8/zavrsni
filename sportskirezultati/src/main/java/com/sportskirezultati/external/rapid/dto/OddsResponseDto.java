package com.sportskirezultati.external.rapid.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class OddsResponseDto {

  private List<OddsItemDto> response;
}
