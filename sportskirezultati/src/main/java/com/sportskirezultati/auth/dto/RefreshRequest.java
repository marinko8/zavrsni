package com.sportskirezultati.auth.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * Dto for refresh token request.
 */
@Getter
@Builder
public class RefreshRequest {

  private String username;
  private String refreshToken;
}
