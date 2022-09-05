package com.sportskirezultati.moderator;

import com.sportskirezultati.common.Constants;
import com.sportskirezultati.common.dto.BusinessResponse;
import com.sportskirezultati.domain.userinfo.UserInfo;
import com.sportskirezultati.domain.userinfo.UserInfoService;
import com.sportskirezultati.exception.ErrorMessages;
import java.time.LocalDate;
import java.util.Collections;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implements {@link ModeratorService}.
 */
@Slf4j
@Service
@AllArgsConstructor
public class ModeratorServiceImpl implements ModeratorService {

  private final UserInfoService userInfoService;

  @Override
  @Transactional
  public BusinessResponse banUser(Long userId) {
    UserInfo userInfo = userInfoService.getByUserId(userId);

    if (userInfo == null) {
      log.warn("User not found: {}", userId);
      return new BusinessResponse(Collections.singletonList(ErrorMessages.USER_NOT_FOUND));
    }

    userInfo.setBannedIndicator(Constants.INDICATOR_YES.charAt(0));
    userInfo.setBannedTo(LocalDate.now().plusDays(10));

    userInfoService.update(userInfo);

    log.info("User {} banned till {}", userId, LocalDate.now().plusDays(10));

    return new BusinessResponse(Collections.emptyList());
  }
}
