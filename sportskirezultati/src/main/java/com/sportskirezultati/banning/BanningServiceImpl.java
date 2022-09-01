package com.sportskirezultati.banning;

import com.sportskirezultati.common.Constants;
import com.sportskirezultati.domain.userinfo.UserInfo;
import com.sportskirezultati.domain.userinfo.UserInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link BanningService}.
 */
@Slf4j
@Service
@AllArgsConstructor
public class BanningServiceImpl implements BanningService {

  private UserInfoService userInfoService;

  @Override
  @Transactional
  public void removeBan(UserInfo userInfo) {
    userInfo.setBannedIndicator(Constants.INDICATOR_NO.charAt(0));
    userInfo.setBannedTo(null);

    userInfoService.update(userInfo);

    log.info("Removed ban for user: {}", userInfo.getUserId());
  }
}
