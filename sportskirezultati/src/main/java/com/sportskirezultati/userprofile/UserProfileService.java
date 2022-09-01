package com.sportskirezultati.userprofile;

import com.sportskirezultati.auth.UserDetailsImpl;
import com.sportskirezultati.common.dto.ProfileDto;

/**
 * Service for user profile info.
 */
public interface UserProfileService {

  /**
   * Fetch profile info.
   */
  ProfileDto getUserInfo(Long userId, UserDetailsImpl userDetails);
}
