package com.sportskirezultati.domain.user;

/**
 * Service for {@link User}.
 */
public interface UserService {

  /**
   * Get user by id.
   */
  User getById(Long userId);

  /**
   * Get user by username.
   */
  User getByUsername(String username);


  /**
   * check if username exists already.
   */
  boolean isUsernameTaken(String username);

  /**
   * check if email exists already.
   */
  boolean isEmailTaken(String email);

  /**
   * Save new user.
   */
  User save(User user);

  /**
   * Update entity.
   */
  User update(User user);
}
