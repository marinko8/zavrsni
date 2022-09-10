package com.sportskirezultati.userprofile;

import com.sportskirezultati.auth.UserDetailsImpl;
import com.sportskirezultati.common.Constants;
import com.sportskirezultati.common.dto.BasicUserInfoDto;
import com.sportskirezultati.common.dto.BetViewDto;
import com.sportskirezultati.common.dto.ProfileDto;
import com.sportskirezultati.config.AppProperties;
import com.sportskirezultati.domain.bet.BetService;
import com.sportskirezultati.domain.friendrequest.FriendRequestService;
import com.sportskirezultati.domain.friends.Friends;
import com.sportskirezultati.domain.friends.FriendsService;
import com.sportskirezultati.domain.user.User;
import com.sportskirezultati.domain.user.UserService;
import com.sportskirezultati.domain.userinfo.UserInfo;
import com.sportskirezultati.domain.userinfo.UserInfoService;
import java.util.List;
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

  private final UserService userService;
  private final UserInfoService userInfoService;
  private final FriendsService friendsService;
  private final FriendRequestService friendRequestService;
  private final BetService betService;
  private final AppProperties appProperties;

  @Override
  public ProfileDto getUserInfo(Long userId, UserDetailsImpl userDetails) {
    boolean isOwner = userDetails.getId().equals(userId);

    User user = userService.getById(userId);
    UserInfo userInfo = userInfoService.getByUserId(userId);
    Integer numberOfFriends = friendsService.countUserFriends(userId);

    List<BasicUserInfoDto> requestsReceived =
        isOwner ? friendRequestService.getRequestsForUser(userId) : null;
    List<BasicUserInfoDto> requestsMade =
        isOwner ? friendRequestService.getRequestsUserMade(userId) : null;
    Friends friends = isOwner ? null : friendsService.findFriendship(userId, userDetails.getId());

    Boolean requestSent = isOwner || friends != null ? null
        : friendRequestService.getForUserSendingAndUserReceiving(userDetails.getId(), userId)
            != null;
    Boolean requestReceived = isOwner || friends != null ? null
        : friendRequestService.getForUserSendingAndUserReceiving(userId, userDetails.getId())
            != null;

    Integer numberOfGames = betService.countByUserId(userId);
    Integer numberOfWinners = betService.countWinnersByUserId(userId);
    List<BetViewDto> bets = betService.getActiveBets(userId);
    bets.forEach(b -> b.setIsActive(true));
    List<BetViewDto> finishedBets = betService.getLastFinishedBets(userId,
        appProperties.getProfileBetsCount());
    finishedBets.forEach(b -> b.setIsActive(false));
    bets.addAll(finishedBets);

    return ProfileDto.builder()
        .id(userId)
        .name(userInfo.getName())
        .surname(userInfo.getSurname())
        .username(user.getUsername())
        .role(user.getRole())
        .points(userInfo.getPoints())
        .bankrupt(userInfo.getBankruptTimes())
        .numberOfGames(numberOfGames)
        .success(finishedBets.isEmpty() ? 100 : (numberOfWinners / finishedBets.size()) * 100)
        .numberOfFriends(numberOfFriends)
        .requestsReceived(requestsReceived)
        .requestsSended(requestsMade)
        .isFriend(friends != null)
        .requestSended(requestSent)
        .requestReceived(requestReceived)
        .banned(Constants.INDICATOR_YES.equals(userInfo.getBannedIndicator().toString()))
        .bannedToDate(userInfo.getBannedTo())
        .bets(bets)
        .build();
  }
}
