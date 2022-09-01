package com.sportskirezultati.auth;

import com.sportskirezultati.auth.dto.LoginRequest;
import com.sportskirezultati.auth.dto.LoginResponse;
import com.sportskirezultati.auth.dto.LogoutResponse;
import com.sportskirezultati.auth.dto.RefreshRequest;
import com.sportskirezultati.auth.dto.RefreshResponse;
import com.sportskirezultati.auth.dto.RegisterRequest;
import com.sportskirezultati.auth.dto.RegisterResponse;
import com.sportskirezultati.common.Constants;
import com.sportskirezultati.common.Role;
import com.sportskirezultati.common.Utils;
import com.sportskirezultati.config.AppProperties;
import com.sportskirezultati.domain.refreshtoken.RefreshToken;
import com.sportskirezultati.domain.refreshtoken.RefreshTokenService;
import com.sportskirezultati.domain.user.User;
import com.sportskirezultati.domain.user.UserService;
import com.sportskirezultati.domain.userinfo.UserInfo;
import com.sportskirezultati.domain.userinfo.UserInfoService;
import com.sportskirezultati.exception.AuthException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link AuthService}.
 */
@Service
@AllArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

  private final AuthenticationManager authenticationManager;
  private final AppProperties appProperties;
  private final RefreshTokenService refreshTokenService;
  private final UserService userService;
  private final UserInfoService userInfoService;
  private final PasswordEncoder encoder;

  @Override
  @Transactional
  public LoginResponse login(LoginRequest request) {
    Authentication authentication = authenticationManager
        .authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    String jwt = Utils.generateJwtToken(userDetails.getUsername(), appProperties.getJwtExpiration(),
        appProperties.getSecretKey());

    List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
        .collect(Collectors.toList());

    RefreshToken refreshToken = refreshTokenService.createNew(userDetails.getId());
    UserInfo userInfo = userInfoService.getByUserId(userDetails.getId());

    log.info("User {} is logged in successfully", userDetails.getId());

    return LoginResponse.builder()
        .userId(userDetails.getId())
        .username(userDetails.getUsername())
        .email(userDetails.getEmail())
        .roles(roles)
        .points(userInfo.getPoints())
        .jwtToken(jwt)
        .refreshToken(refreshToken.getToken())
        .build();
  }

  @Override
  @Transactional
  public RegisterResponse signUp(RegisterRequest request) {
    List<String> errors = new ArrayList<>();

    if (userService.isUsernameTaken(request.getUsername())) {
      errors.add("Korisničko ime je zauzeto!");
    }

    if (userService.isEmailTaken(request.getEmail())) {
      errors.add("Email je zauzet!");
    }

    if (errors.isEmpty()) {
      User user = userService.save(builtSignUpUser(request));
      userInfoService.save(buildUserInfo(request, user.getId()));

      log.info("User {} is signed up successfully", user.getId());
    }

    return RegisterResponse.builder().errors(errors).build();
  }

  @Override
  @Transactional
  public RefreshResponse refreshToken(RefreshRequest request) {
    RefreshToken refreshToken = refreshTokenService.findByRefreshToken(request.getRefreshToken());

    if (refreshToken == null) {
      throw new AuthException("Refresh token nije u bazi");
    }

    refreshTokenService.verify(refreshToken);

    String token = Utils.generateJwtToken(request.getUsername(), appProperties.getJwtExpiration(),
        appProperties.getSecretKey());

    return RefreshResponse.builder().jwtToken(token).build();
  }

  @Override
  @Transactional
  public LogoutResponse logout(Long userId) {
    refreshTokenService.deleteByUserId(userId);
    log.info("User {} is logged out successfully", userId);
    return LogoutResponse.builder().message("Odjava uspješna!").build();
  }

  private User builtSignUpUser(RegisterRequest request) {
    return User.builder().username(request.getUsername())
        .email(request.getEmail())
        .password(encoder.encode(request.getPassword()))
        .role(Role.USER.getCode())
        .disabledIndicator(Constants.INDICATOR_NO).build();
  }

  private UserInfo buildUserInfo(RegisterRequest request, Long userId) {
    return UserInfo.builder().userId(userId)
        .name(request.getName())
        .surname(request.getSurname())
        .bannedIndicator(Constants.INDICATOR_NO.charAt(0))
        .points(1000.0)
        .bankruptTimes(0).build();
  }
}
