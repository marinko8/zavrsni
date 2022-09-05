package com.sportskirezultati.domain.friendrequest;

import com.sportskirezultati.common.dto.BasicUserInfoDto;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Service for {@link FriendRequest}.
 */
public interface FriendRequestService {

  /**
   * Get all friend requests user have.
   */
  List<BasicUserInfoDto> getRequestsForUser(Long userId);

  /**
   * Get request between two users.
   */
  FriendRequest getForUserSendingAndUserReceiving(Long userSending,
      @Param("userReceiving") Long userReceiving);

  /**
   * Save new Entity.
   */
  FriendRequest save(FriendRequest friendRequest);

  /**
   * Delete by user sending and user receiving.
   */
  void delete(Long userSending, Long userReceiving);
}
