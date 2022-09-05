package com.sportskirezultati.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum BetType {
  WINNER("01", "Match winner");

  private final String code;
  private final String description;

  /**
   * Fetch event type by code.
   */
  public static BetType fetchNameByCode(String code) {
    for (BetType type : BetType.values()) {
      if (type.getCode().equals(code)) {
        return type;
      }
    }
    return null;
  }
}
