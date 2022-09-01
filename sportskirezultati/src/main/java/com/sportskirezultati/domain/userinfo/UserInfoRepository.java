package com.sportskirezultati.domain.userinfo;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link UserInfo}.
 */
@Repository
@Mapper
public interface UserInfoRepository {

  /**
   * Find details by user id.
   */
  UserInfo findByUserId(@Param("userId") Long userId);

  /**
   * Find details for all user friends.
   */
  List<UserInfo> findByFriend(@Param("userId") Long userId);

  /**
   * Find all that match by name, surname or username.
   */
  List<UserInfo> search(@Param("searchText") String searchText);

  /**
   * Save new entity.
   */
  long save(UserInfo userInfo);

  /**
   * Update entity.
   */
  int update(UserInfo userInfo);
}
