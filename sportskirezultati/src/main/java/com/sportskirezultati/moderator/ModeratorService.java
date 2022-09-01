package com.sportskirezultati.moderator;

import com.sportskirezultati.common.dto.BusinessResponse;
import java.time.LocalDate;

/**
 * Service for moderator rights.
 */
public interface ModeratorService {

  /**
   * Ban user till date.
   */
  BusinessResponse banUser(Long userId, LocalDate toDate);

  /**
   * Change user points.
   */
  BusinessResponse changeUserPoints(Long userId, Long points);
}
