package com.sportskirezultati.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusDto {
  @JsonProperty("long")
  private String longName;

  @JsonProperty("short")
  private String shortName;

  private Integer elapsed;

  private String seconds;
}
