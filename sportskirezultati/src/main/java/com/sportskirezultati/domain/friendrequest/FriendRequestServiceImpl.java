package com.sportskirezultati.domain.friendrequest;

import com.sportskirezultati.common.dto.BasicUserInfoDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link FriendRequestService}.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class FriendRequestServiceImpl implements FriendRequestService {

  private final FriendRequestRepository repository;

  @Override
  public List<BasicUserInfoDto> getRequestsForUser(Long userId) {
    return repository.findRequestsForUser(userId);
  }

  @Override
  public FriendRequest getForUserSendingAndUserReceiving(Long userSending, Long userReceiving) {
    return repository.findByUserSendingAndUserReceiving(userSending, userReceiving);
  }

  @Override
  @Transactional
  public FriendRequest save(FriendRequest friendRequest) {
    repository.save(friendRequest);
    log.info("Saved friend request with id: {}", friendRequest.getId());
    return friendRequest;
  }

  @Override
  @Transactional
  public void delete(Long userSending, Long userReceiving) {
    repository.delete(userSending, userReceiving);
    log.info("Deleted friends request with user sending id: {} and user receiving id: {}",
        userSending, userReceiving);
  }
}
