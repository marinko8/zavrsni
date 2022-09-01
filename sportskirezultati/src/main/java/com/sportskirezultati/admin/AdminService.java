package com.sportskirezultati.admin;

import com.sportskirezultati.common.dto.BusinessResponse;

/**
 * Service for admin rights.
 */
public interface AdminService {

  /**
   * Disable user.
   */
  BusinessResponse disableUser(Long userId);

  /**
   * Give mod role to the user.
   */
  BusinessResponse giveModRoleToUser(Long userId);

  /**
   * Remove mod role from the user.
   */
  BusinessResponse removeModRoleFromUser(Long userId);
}
