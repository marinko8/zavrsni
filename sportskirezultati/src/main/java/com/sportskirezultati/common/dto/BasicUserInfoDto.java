package com.sportskirezultati.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Basic user info.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasicUserInfoDto {

  private Long id;
  private String name;
  private String surname;
  private String username;
}
