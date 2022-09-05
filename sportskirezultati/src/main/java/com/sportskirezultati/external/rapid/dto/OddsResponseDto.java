package com.sportskirezultati.external.rapid.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OddsResponseDto {

  private List<OddsItemDto> response;
}
