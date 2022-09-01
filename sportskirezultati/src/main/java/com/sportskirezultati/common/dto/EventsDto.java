package com.sportskirezultati.common.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventsDto {
  private List<? extends Event> events;
}
