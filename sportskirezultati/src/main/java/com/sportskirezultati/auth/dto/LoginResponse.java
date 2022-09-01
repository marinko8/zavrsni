package com.sportskirezultati.auth.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * Dto for login response.
 */
@Data
@Builder
public class LoginResponse {

  private Long userId;
  private String username;
  private String email;
  private List<String> roles;
  private Double points;
  private Integer activeBets;

  private String jwtToken;
  private String refreshToken;

}
