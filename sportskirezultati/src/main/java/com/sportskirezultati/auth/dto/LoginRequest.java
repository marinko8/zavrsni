package com.sportskirezultati.auth.dto;

import lombok.Data;

/**
 * Dto for login request.
 */
@Data
public class LoginRequest {

  private String username;
  private String password;
}
