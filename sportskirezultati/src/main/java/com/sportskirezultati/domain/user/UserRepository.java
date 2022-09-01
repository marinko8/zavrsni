package com.sportskirezultati.domain.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link User}.
 */
@Repository
@Mapper
public interface UserRepository {

  /**
   * Find user by id.
   */
  User findById(@Param("userId") Long userID);

  /**
   * Find user by username.
   */
  User findByUsername(@Param("username") String username);

  /**
   * check if username exists already.
   */
  int isUsernameTaken(@Param("username") String username);

  /**
   * check if email exists already.
   */
  int isEmailTaken(@Param("email") String email);

  /**
   * Save new user.
   */
  long save(User user);

  /**
   * Update entity.
   */
  int update(User user);
}
