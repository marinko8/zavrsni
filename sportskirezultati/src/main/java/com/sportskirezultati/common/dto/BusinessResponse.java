package com.sportskirezultati.common.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * General business API response.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessResponse {

  private List<String> errors;
}
