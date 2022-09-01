package com.sportskirezultati.auth.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Dto for refresh token response.
 */
@Data
@Builder
public class RefreshResponse {

  private String jwtToken;
}
