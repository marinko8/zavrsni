package com.sportskirezultati.domain.userinfo;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

/**
 * User info entity.
 */
@Data
@Builder
public class UserInfo {

  private Long id;
  private Long userId;
  private String name;
  private String surname;
  private Character bannedIndicator;
  private LocalDate bannedTo;
  private Double points;
  private Integer bankruptTimes;
}
