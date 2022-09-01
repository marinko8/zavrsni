package com.sportskirezultati.auth;

import com.sportskirezultati.auth.dto.LoginRequest;
import com.sportskirezultati.auth.dto.LoginResponse;
import com.sportskirezultati.auth.dto.LogoutResponse;
import com.sportskirezultati.auth.dto.RefreshRequest;
import com.sportskirezultati.auth.dto.RefreshResponse;
import com.sportskirezultati.auth.dto.RegisterRequest;
import com.sportskirezultati.auth.dto.RegisterResponse;
import com.sportskirezultati.common.EndpointUrls;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for authentication requests.
 */
@RestController
@AllArgsConstructor
@RequestMapping(EndpointUrls.AUTH_URL)
public class AuthController {

  private final AuthService authService;

  /**
   * Check credentials and login
   */
  @PostMapping(EndpointUrls.AUTH_LOGIN_URL)
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
    return ResponseEntity.ok(authService.login(request));
  }

  /**
   * Check if unique username and password and save user.
   */
  @PostMapping(EndpointUrls.AUTH_REGISTER_URL)
  public ResponseEntity<RegisterResponse> registerUser(@RequestBody RegisterRequest request) {
    return ResponseEntity.status(HttpStatus.OK).body(authService.signUp(request));
  }

  /**
   * Return new jwt token.
   */
  @PostMapping(EndpointUrls.AUTH_REFRESH_TOKEN_URL)
  public ResponseEntity<RefreshResponse> refreshToken(@Valid @RequestBody RefreshRequest request) {
    return ResponseEntity.ok(authService.refreshToken(request));
  }

  /**
   * Logout user.
   */
  @PostMapping(EndpointUrls.AUTH_LOGOUT_URL)
  public ResponseEntity<LogoutResponse> logoutUser(@RequestParam Long userId) {
    return ResponseEntity.ok(authService.logout(userId));
  }
}
