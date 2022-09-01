package com.sportskirezultati.domain.refreshtoken;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link RefreshToken}.
 */
@Repository
@Mapper
public interface RefreshTokenRepository {

  /**
   * Find by token.
   */
  RefreshToken findByRefreshToken(@Param("refreshToken") String refreshToken);

  /**
   * delete token by user id.
   */
  int deleteByUserId(@Param("userId") Long userId);

  /**
   * Save new refresh token.
   */
  RefreshToken save(@Param("refreshToken") RefreshToken refreshToken);
}
