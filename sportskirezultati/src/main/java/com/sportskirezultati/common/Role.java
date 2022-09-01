package com.sportskirezultati.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Roles enum.
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Role {
  USER("01", "Običan korisnik"),
  MOD("02", "Moderator"),
  ADMIN("03", "Administrator");

  private final String code;
  private final String description;

  /**
   * Fetch role name by role code.
   */
  public static String fetchNameByCode(String code) {
    for (Role role : Role.values()) {
      if (role.getCode().equals(code)) {
        return role.name();
      }
    }
    return null;
  }
}
