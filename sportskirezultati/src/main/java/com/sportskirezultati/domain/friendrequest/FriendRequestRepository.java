package com.sportskirezultati.domain.friendrequest;

import com.sportskirezultati.common.dto.BasicUserInfoDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link FriendRequest}.
 */
@Repository
@Mapper
public interface FriendRequestRepository {

  /**
   * Find all friend requests user have.
   */
  List<BasicUserInfoDto> findRequestsForUser(@Param("userId") Long userId);

  /**
   * Find request between two users.
   */
  FriendRequest findByUserSendingAndUserReceiving(@Param("userSending") Long userSending,
      @Param("userReceiving") Long userReceiving);

  /**
   * Save new Entity.
   */
  long save(FriendRequest friendRequest);

  /**
   * Delete by user sending.
   */
  int deleteByUserSending(@Param("userId") Long userId);

  /**
   * Delete by user receiving.
   */
  int deleteByUserReceiving(@Param("userId") Long userId);
}
