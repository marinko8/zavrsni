package com.sportskirezultati.common.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BetDto {
  private Integer id;
  private String name;
  private List<BetValueDto> values;
}
