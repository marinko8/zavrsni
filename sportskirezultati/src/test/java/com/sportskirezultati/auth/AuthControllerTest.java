package com.sportskirezultati.auth;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sportskirezultati.auth.dto.LoginRequest;
import com.sportskirezultati.auth.dto.LoginResponse;
import com.sportskirezultati.common.EndpointUrls;
import com.sportskirezultati.domain.user.User;
import com.sportskirezultati.domain.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AuthControllerTest {

  @Autowired
  private AuthController authController;

  @Autowired
  private UserService userService;

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  private static final String BASE_PATH = "http://localhost:";

  @Test
  void login() {
    LoginRequest request = new LoginRequest();
    request.setUsername("username");
    request.setPassword("password");

    String url = BASE_PATH + port + EndpointUrls.AUTH_URL + EndpointUrls.AUTH_LOGIN_URL;
    ResponseEntity<LoginResponse> result = restTemplate.postForEntity(
        url, request,
        LoginResponse.class);

    assertSame(HttpStatus.FORBIDDEN, result.getStatusCode());
  }

  @Test
  void registerUser() {
  }
}