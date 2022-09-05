package com.sportskirezultati.domain.friends;

import com.sportskirezultati.auth.UserDetailsImpl;
import com.sportskirezultati.common.dto.BusinessResponse;
import com.sportskirezultati.domain.friendrequest.FriendRequest;
import com.sportskirezultati.domain.friendrequest.FriendRequestService;
import java.time.LocalDate;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link FriendsService}.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class FriendsServiceImpl implements FriendsService {

  private final FriendsRepository repository;
  private final FriendRequestService friendRequestService;

  @Override
  public Integer countUserFriends(Long userId) {
    return repository.countUserFriends(userId);
  }

  @Override
  public Friends findFriendship(Long userOne, Long userTwo) {
    return repository.findFriendship(userOne, userTwo);
  }

  @Override
  @Transactional
  public Friends save(Friends friends) {
    repository.save(friends);
    log.info("Saved friends record with id: {}", friends.getId());
    return friends;
  }

  @Override
  @Transactional
  public void delete(Long userOneId, Long userTwoId) {
    repository.delete(userOneId, userTwoId);
    log.info("Deleted friends record between user: {} and user: {}", userOneId, userTwoId);
  }

  @Override
  @Transactional
  public BusinessResponse addFriend(UserDetailsImpl userDetails, Long userId) {
    FriendRequest request = FriendRequest.builder().userSending(userDetails.getId())
        .userReceiving(userId).build();
    friendRequestService.save(request);
    return new BusinessResponse(Collections.emptyList());
  }

  @Override
  @Transactional
  public BusinessResponse removeRequest(UserDetailsImpl userDetails, Long userId) {
    friendRequestService.delete(userDetails.getId(), userId);
    return new BusinessResponse(Collections.emptyList());
  }

  @Override
  @Transactional
  public BusinessResponse acceptRequest(UserDetailsImpl userDetails, Long userId) {
    friendRequestService.delete(userId, userDetails.getId());

    Friends friends = Friends.builder().userOne(userId).userTwo(userDetails.getId()).fromDate(
        LocalDate.now()).build();
    save(friends);

    return new BusinessResponse(Collections.emptyList());
  }

  @Override
  @Transactional
  public BusinessResponse declineRequest(UserDetailsImpl userDetails, Long userId) {
    friendRequestService.delete(userId, userDetails.getId());
    return new BusinessResponse(Collections.emptyList());
  }

  @Override
  @Transactional
  public BusinessResponse removeFriend(UserDetailsImpl userDetails, Long userId) {
    delete(userDetails.getId(), userId);

    return new BusinessResponse(Collections.emptyList());
  }
}
