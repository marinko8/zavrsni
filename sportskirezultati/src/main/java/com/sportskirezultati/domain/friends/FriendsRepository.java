package com.sportskirezultati.domain.friends;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link Friends}.
 */
@Repository
@Mapper
public interface FriendsRepository {

  Integer countUserFriends(@Param("userId") Long userId);

  Friends findFriendship(@Param("userOne") Long userOne, @Param("userTwo") Long userTwo);

  /**
   * Save new entity.
   */
  long save(Friends friends);

  /**
   * Delete friends record.
   */
  long delete(@Param("userOneId") Long userOneId, @Param("userTwoId") Long userTwoId);
}
