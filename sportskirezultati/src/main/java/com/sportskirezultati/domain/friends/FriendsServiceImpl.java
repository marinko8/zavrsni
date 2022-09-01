package com.sportskirezultati.domain.friends;

import com.sportskirezultati.common.dto.BasicUserInfoDto;
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

  @Override
  public BasicUserInfoDto findAllFriendsForUser(Long userId) {
    return null;
  }

  @Override
  public Integer countUserFriends(Long userId) {
    return null;
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
}
