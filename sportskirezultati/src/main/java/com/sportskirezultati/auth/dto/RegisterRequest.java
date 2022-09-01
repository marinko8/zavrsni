package com.sportskirezultati.auth.dto;

import lombok.Getter;

/**
 * Dto for registration request.
 */
@Getter
public class RegisterRequest {
  private String name;
  private String surname;
  private String username;
  private String email;
  private String password;
}
