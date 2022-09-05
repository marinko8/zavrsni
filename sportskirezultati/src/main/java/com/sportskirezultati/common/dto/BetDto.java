package com.sportskirezultati.common.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BetDto {
  private Integer id;
  private String name;
  private List<BetValueDto> values;
}
