package com.sportskirezultati.friendsmanagment;

import com.sportskirezultati.auth.UserDetailsImpl;
import com.sportskirezultati.common.EndpointUrls;
import com.sportskirezultati.common.dto.BasicUserInfoDto;
import com.sportskirezultati.common.dto.BusinessResponse;
import com.sportskirezultati.domain.friends.FriendsService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for friends management.
 */
@RestController
@AllArgsConstructor
@RequestMapping(EndpointUrls.FRIENDS_API)
public class FriendsController {

  private final FriendsService friendsService;

  @GetMapping(EndpointUrls.FRIENDS_LIST)
  public ResponseEntity<List<BasicUserInfoDto>> getFriendsList(Authentication authentication) {
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    return ResponseEntity.ok(friendsService.findUserFriends(userDetails.getId()));
  }

  @PostMapping(EndpointUrls.ADD_FRIEND)
  public ResponseEntity<BusinessResponse> addFriend(Authentication authentication,
      @RequestParam Long userId) {
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    return ResponseEntity.ok(friendsService.addFriend(userDetails, userId));
  }

  @PostMapping(EndpointUrls.REMOVE_REQUEST)
  public ResponseEntity<BusinessResponse> removeRequest(Authentication authentication,
      @RequestParam Long userId) {
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    return ResponseEntity.ok(friendsService.removeRequest(userDetails, userId));
  }

  @PostMapping(EndpointUrls.ACCEPT_REQUEST)
  public ResponseEntity<BusinessResponse> acceptRequest(Authentication authentication,
      @RequestParam Long userId) {
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    return ResponseEntity.ok(friendsService.acceptRequest(userDetails, userId));
  }

  @PostMapping(EndpointUrls.DECLINE_REQUEST)
  public ResponseEntity<BusinessResponse> declineRequest(Authentication authentication,
      @RequestParam Long userId) {
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    return ResponseEntity.ok(friendsService.declineRequest(userDetails, userId));
  }

  @PostMapping(EndpointUrls.REMOVE_FRIEND)
  public ResponseEntity<BusinessResponse> removeFriend(Authentication authentication,
      @RequestParam Long userId) {
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    return ResponseEntity.ok(friendsService.removeFriend(userDetails, userId));
  }


}
