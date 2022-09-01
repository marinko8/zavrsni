package com.sportskirezultati.domain.user;

import lombok.Builder;
import lombok.Data;

/**
 * User entity.
 */
@Data
@Builder
public class User {

  private Long id;
  private String username;
  private String email;
  private String password;
  private String role;
  private String disabledIndicator;
}
