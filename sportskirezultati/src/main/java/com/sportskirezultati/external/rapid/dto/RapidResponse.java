package com.sportskirezultati.external.rapid.dto;

import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class RapidResponse {
  private String get;
  private Map<String, String> parameters;
  private List<?> errors;
  private Integer results;
  private Map<String, Integer> paging;
}
