package com.sportskirezultati.userprofile;

import com.sportskirezultati.auth.UserDetailsImpl;
import com.sportskirezultati.common.EndpointUrls;
import com.sportskirezultati.common.dto.ProfileDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for user profile requests.
 */
@RestController
@AllArgsConstructor
@RequestMapping(EndpointUrls.PROFILE_API)
public class UserProfileController {

  private final UserProfileService userProfileService;

  @GetMapping(EndpointUrls.PROFILE)
  public ResponseEntity<ProfileDto> getUserProfile(Authentication authentication,
      @RequestParam Long userId) {
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    return ResponseEntity.ok(userProfileService.getUserInfo(userId, userDetails));
  }
}
