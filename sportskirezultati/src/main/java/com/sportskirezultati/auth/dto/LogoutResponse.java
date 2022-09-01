package com.sportskirezultati.auth.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Dto for logout response.
 */
@Data
@Builder
public class LogoutResponse {

  private String message;
}
