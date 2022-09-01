package com.sportskirezultati.domain.userinfo;

import java.util.List;

/**
 * Service for {@link UserInfo}.
 */
public interface UserInfoService {

  /**
   * Get details by user id.
   */
  UserInfo getByUserId(Long userId);

  /**
   * Get details for all user friends.
   */
  List<UserInfo> getByFriend(Long userId);

  /**
   * Get all that match by name, surname or username.
   */
  List<UserInfo> search(String searchText);

  /**
   * Save new entity.
   */
  UserInfo save(UserInfo userInfo);

  /**
   * Update entity.
   */
  UserInfo update(UserInfo userInfo);

  List<UserInfo> getUsersForBanRemove();
}
