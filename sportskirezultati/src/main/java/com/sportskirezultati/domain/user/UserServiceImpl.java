package com.sportskirezultati.domain.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link UserService}.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

  private final UserRepository repository;

  @Override
  public User getById(Long userId) {
    return repository.findById(userId);
  }

  @Override
  public User getByUsername(String username) {
    return repository.findByUsername(username);
  }

  @Override
  public boolean isUsernameTaken(String username) {
    return repository.isUsernameTaken(username) > 0;
  }

  @Override
  public boolean isEmailTaken(String email) {
    return repository.isEmailTaken(email) > 0;
  }

  @Override
  @Transactional
  public User save(User user) {
    repository.save(user);
    log.info("Saved user with id: {}", user.getId());
    return user;
  }

  @Override
  @Transactional
  public User update(User newEntity) {
    repository.update(newEntity);

    log.info("Updated user with id: {}", newEntity.getId());

    return newEntity;
  }
}
