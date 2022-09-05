package com.sportskirezultati.moderator;

import com.sportskirezultati.common.dto.BusinessResponse;

/**
 * Service for moderator rights.
 */
public interface ModeratorService {

  /**
   * Ban user till date.
   */
  BusinessResponse banUser(Long userId);
}
