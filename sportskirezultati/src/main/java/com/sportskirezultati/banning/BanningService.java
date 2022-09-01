package com.sportskirezultati.banning;

import com.sportskirezultati.domain.userinfo.UserInfo;

/**
 * Service for removing user ban indicator.
 */
public interface BanningService {

  /**
   * Remove ban.
   */
  void removeBan(UserInfo userInfo);
}
