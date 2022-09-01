package com.sportskirezultati.domain.refreshtoken;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Entity for refresh token.
 */
@Data
@Builder
@AllArgsConstructor
public class RefreshToken {

  private Long id;

  private Long userId;

  private String token;

  private Instant expireAt;
}
