package com.sportskirezultati.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusDto {
  @JsonProperty("long")
  private String longName;

  @JsonProperty("short")
  private String shortName;

  private Integer elapsed;

  private String seconds;
}
