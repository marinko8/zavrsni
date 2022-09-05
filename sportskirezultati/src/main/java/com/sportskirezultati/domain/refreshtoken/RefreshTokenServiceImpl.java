package com.sportskirezultati.domain.refreshtoken;

import com.sportskirezultati.config.AppProperties;
import com.sportskirezultati.exception.AuthException;
import java.time.Instant;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link RefreshTokenService}.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RefreshTokenServiceImpl implements RefreshTokenService {

  private final RefreshTokenRepository repository;
  private final AppProperties appProperties;

  @Override
  @Transactional
  public RefreshToken createNew(Long userId) {
    RefreshToken refreshToken = RefreshToken.builder().userId(userId)
        .token(UUID.randomUUID().toString())
        .expireAt(Instant.now().plusMillis(appProperties.getRefreshExpiration())).build();
    repository.save(refreshToken);

    log.info("Saved refresh token with id: {}", refreshToken.getId());
    return refreshToken;
  }

  @Override
  public RefreshToken findByRefreshToken(String refreshToken) {
    return repository.findByRefreshToken(refreshToken);
  }

  @Override
  public void verify(RefreshToken refreshToken) {
    if (refreshToken.getExpireAt().isAfter(Instant.now())) {
      throw new AuthException("Refresh token istekao");
    }
  }

  @Override
  @Transactional
  public void deleteByUserId(Long userId) {
    int isDeleted = repository.deleteByUserId(userId);

    if (isDeleted != 0) {
      log.info("Deleted refresh token with user id: {}", userId);
    } else {
      throw new AuthException("Greška pri brisanju refresh tokena!");
    }
  }
}
