package com.sportskirezultati.admin;

import com.sportskirezultati.common.Constants;
import com.sportskirezultati.common.Role;
import com.sportskirezultati.common.dto.BusinessResponse;
import com.sportskirezultati.domain.user.User;
import com.sportskirezultati.domain.user.UserService;
import com.sportskirezultati.exception.ErrorMessages;
import java.util.Collections;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implements {@link AdminService}.
 */
@Slf4j
@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

  private final UserService userService;

  @Override
  @Transactional
  public BusinessResponse disableUser(Long userId) {
    User user = userService.getById(userId);

    if (user == null) {
      log.warn("User not found: {}", userId);
      return new BusinessResponse(Collections.singletonList(ErrorMessages.USER_NOT_FOUND));
    }

    user.setDisabledIndicator(Constants.INDICATOR_YES);
    userService.update(user);

    return new BusinessResponse(Collections.emptyList());
  }

  @Override
  @Transactional
  public BusinessResponse giveModRoleToUser(Long userId) {
    return changeUserRole(userId, Role.MOD.getCode());
  }

  @Override
  @Transactional
  public BusinessResponse removeModRoleFromUser(Long userId) {
    return changeUserRole(userId, Role.USER.getCode());
  }

  private BusinessResponse changeUserRole(Long userId, String role) {
    User user = userService.getById(userId);

    if (user == null) {
      log.warn("User not found: {}", userId);
      return new BusinessResponse(Collections.singletonList(ErrorMessages.USER_NOT_FOUND));
    }

    user.setRole(role);
    userService.update(user);

    return new BusinessResponse(Collections.emptyList());
  }
}
