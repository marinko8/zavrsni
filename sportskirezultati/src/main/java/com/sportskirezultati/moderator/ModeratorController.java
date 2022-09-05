package com.sportskirezultati.moderator;

import com.sportskirezultati.common.EndpointUrls;
import com.sportskirezultati.common.dto.BusinessResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for moderator panel requests.
 */
@RestController
@AllArgsConstructor
@RequestMapping(EndpointUrls.MOD_API)
public class ModeratorController {

  private final ModeratorService moderatorService;

  @PostMapping(EndpointUrls.BAN_USER)
  public ResponseEntity<BusinessResponse> banUser(@RequestParam Long userId) {
    return ResponseEntity.ok(moderatorService.banUser(userId));
  }
}
