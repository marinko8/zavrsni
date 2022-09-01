package com.sportskirezultati.domain.friends;

import com.sportskirezultati.common.dto.BasicUserInfoDto;
import org.apache.ibatis.annotations.Param;

/**
 * Service for {@link Friends}.
 */
public interface FriendsService {

  /**
   * Returns all user friends.
   */
  BasicUserInfoDto findAllFriendsForUser(Long userId);

  /**
   * Returns number of user friends.
   */
  Integer countUserFriends(Long userId);

  /**
   * Save new entity.
   */
  Friends save(Friends friends);


  /**
   * Delete friends record.
   */
  void delete(@Param("userOneId") Long userOneId, @Param("userTwoId") Long userTwoId);
}
