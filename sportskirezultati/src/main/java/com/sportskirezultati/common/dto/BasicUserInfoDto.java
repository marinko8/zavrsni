package com.sportskirezultati.common.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Basic user info.
 */
@Data
@Builder
public class BasicUserInfoDto {

  private Long id;
  private String name;
  private String surname;
  private String username;
}
