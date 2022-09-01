package com.sportskirezultati.banning;

import com.sportskirezultati.domain.userinfo.UserInfo;
import com.sportskirezultati.domain.userinfo.UserInfoService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link BanRemoveProcessingService}.
 */
@Slf4j
@Service
@AllArgsConstructor
public class BanRemoveProcessingServiceImpl implements BanRemoveProcessingService {

  private final UserInfoService userInfoService;
  private final BanningService banningService;

  @Scheduled(cron = "#{appProperties.banRemoveCron}")
  @Override
  public void processBanRemove() {
    List<UserInfo> bannedUser = userInfoService.getUsersForBanRemove();

    bannedUser.forEach(banningService::removeBan);
  }
}
