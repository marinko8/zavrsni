package com.sportskirezultati.domain.friends;

import com.sportskirezultati.auth.UserDetailsImpl;
import com.sportskirezultati.common.dto.BasicUserInfoDto;
import com.sportskirezultati.common.dto.BusinessResponse;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Service for {@link Friends}.
 */
public interface FriendsService {

  List<BasicUserInfoDto> findUserFriends(Long userId);

  /**
   * Returns number of user friends.
   */
  Integer countUserFriends(Long userId);

  Friends findFriendship(Long userOne, Long userTwo);

  /**
   * Save new entity.
   */
  Friends save(Friends friends);


  /**
   * Delete friends record.
   */
  void delete(Long userOneId, Long userTwoId);

  BusinessResponse addFriend(UserDetailsImpl userDetails, Long userId);

  BusinessResponse removeRequest(UserDetailsImpl userDetails, Long userId);

  BusinessResponse acceptRequest(UserDetailsImpl userDetails, Long userId);

  BusinessResponse declineRequest(UserDetailsImpl userDetails, Long userId);

  BusinessResponse removeFriend(UserDetailsImpl userDetails, Long userId);
}
