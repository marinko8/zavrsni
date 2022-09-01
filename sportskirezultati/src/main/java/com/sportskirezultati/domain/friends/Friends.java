package com.sportskirezultati.domain.friends;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

/**
 * Friends entity.
 */
@Data
@Builder
public class Friends {
  private Long id;
  private Long userOne;
  private Long userTwo;
  private LocalDate fromDate;
}
