package com.sportskirezultati.domain.userinfo;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link UserInfoService}.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

  private final UserInfoRepository repository;

  @Override
  public UserInfo getByUserId(Long userId) {
    return repository.findByUserId(userId);
  }

  @Override
  public List<UserInfo> getByFriend(Long userId) {
    return repository.findByFriend(userId);
  }

  @Override
  public List<UserInfo> search(String searchText) {
    return repository.search(searchText);
  }

  @Override
  @Transactional
  public UserInfo save(UserInfo userInfo) {
    repository.save(userInfo);
    log.info("Saved user info with id: {}", userInfo.getId());

    return userInfo;
  }


  @Override
  @Transactional
  public UserInfo update(UserInfo newEntity) {
    repository.update(newEntity);

    log.info("Updated user info with id: {}", newEntity.getId());

    return newEntity;
  }

  @Override
  public List<UserInfo> getUsersForBanRemove() {
    return null;
  }


}
