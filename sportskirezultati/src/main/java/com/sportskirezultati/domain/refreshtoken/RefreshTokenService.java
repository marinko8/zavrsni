package com.sportskirezultati.domain.refreshtoken;

/**
 * Service for {@link RefreshToken}.
 */
public interface RefreshTokenService {

  /**
   * Create and save new refresh token.
   */
  RefreshToken createNew(Long userId);

  /**
   * Find by token.
   */
  RefreshToken findByRefreshToken(String refreshToken);

  /**
   * Verify token.
   */
  void verify(RefreshToken refreshToken);

  /**
   * delete token by user id.
   */
  void deleteByUserId(Long userId);
}
