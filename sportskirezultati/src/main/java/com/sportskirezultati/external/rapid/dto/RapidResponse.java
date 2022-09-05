package com.sportskirezultati.external.rapid.dto;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RapidResponse {
  private String get;
  private List<?> errors;
  private Integer results;
}
