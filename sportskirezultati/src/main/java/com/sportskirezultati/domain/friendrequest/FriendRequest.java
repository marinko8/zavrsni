package com.sportskirezultati.domain.friendrequest;

import lombok.Builder;
import lombok.Data;

/**
 * Friend request entity.
 */
@Data
@Builder
public class FriendRequest {
  private Long id;
  private Long userSending;
  private Long userReceiving;
}
