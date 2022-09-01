package com.sportskirezultati.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/** Type of the event. */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum EventType {
  FOOTBALL("01", "Nogomet"),
  BASKETBALL("02", "Košarka");

  private final String code;
  private final String description;

  /**
   * Fetch event type by code.
   */
  public static EventType fetchNameByCode(String code) {
    for (EventType event : EventType.values()) {
      if (event.getCode().equals(code)) {
        return event;
      }
    }
    return null;
  }
}
