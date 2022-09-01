package com.sportskirezultati.common.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookmakerDto {
  private Integer id;
  private String name;
  private List<BetDto> bets;
}
