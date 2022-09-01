package com.sportskirezultati.auth;


import com.sportskirezultati.auth.dto.LoginRequest;
import com.sportskirezultati.auth.dto.LoginResponse;
import com.sportskirezultati.auth.dto.LogoutResponse;
import com.sportskirezultati.auth.dto.RefreshRequest;
import com.sportskirezultati.auth.dto.RefreshResponse;
import com.sportskirezultati.auth.dto.RegisterRequest;
import com.sportskirezultati.auth.dto.RegisterResponse;

/** Service for authentication. */
public interface AuthService {

  /** Check credentials and login */
  LoginResponse login(LoginRequest request);

  /** Check if unique username and password and save user. */
  RegisterResponse signUp(RegisterRequest request);

  /** Return new jwt token. */
  RefreshResponse refreshToken(RefreshRequest request);

  /** Logout user. */
  LogoutResponse logout(Long userId);
}
