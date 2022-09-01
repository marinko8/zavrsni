package com.sportskirezultati.userprofile;

import com.sportskirezultati.auth.UserDetailsImpl;
import com.sportskirezultati.common.dto.ProfileDto;
import com.sportskirezultati.domain.friendrequest.FriendRequestService;
import com.sportskirezultati.domain.friends.FriendsService;
import com.sportskirezultati.domain.userinfo.UserInfo;
import com.sportskirezultati.domain.userinfo.UserInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link UserProfileService}.
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

  private final UserInfoService userInfoService;
  private final FriendsService friendsService;
  private final FriendRequestService friendRequestService;

  @Override
  public ProfileDto getUserInfo(Long userId, UserDetailsImpl userDetails) {
    boolean isOwner = userDetails.getId().equals(userId);

    UserInfo userInfo = userInfoService.getByUserId(userId);
    Integer numberOfFriends = friendsService.countUserFriends(userId);

    boolean requestSent = isOwner ? null
        : friendRequestService.getForUserSendingAndUserReceiving(userDetails.getId(), userId)
            != null;
    boolean requestReceived = isOwner ? null
        : friendRequestService.getForUserSendingAndUserReceiving(userId, userDetails.getId())
            != null;

    return ProfileDto.builder().build();
  }
}
