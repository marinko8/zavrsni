package com.sportskirezultati.admin;

import com.sportskirezultati.common.EndpointUrls;
import com.sportskirezultati.common.dto.BusinessResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for admin panel requests.
 */
@RestController
@AllArgsConstructor
@RequestMapping(EndpointUrls.ADMIN_API)
public class AdminController {

  private final AdminService adminService;

  @PostMapping(EndpointUrls.DISABLE_USER)
  public ResponseEntity<BusinessResponse> disableUser(@RequestParam Long userId) {
    return ResponseEntity.ok(adminService.disableUser(userId));
  }

  @PostMapping(EndpointUrls.GIVE_MOD)
  public ResponseEntity<BusinessResponse> giveModRoleToUser(@RequestParam Long userId) {
    return ResponseEntity.ok(adminService.giveModRoleToUser(userId));
  }

  @PostMapping(EndpointUrls.REMOVE_MOD)
  public ResponseEntity<BusinessResponse> removeModRoleFromUser(@RequestParam Long userId) {
    return ResponseEntity.ok(adminService.removeModRoleFromUser(userId));
  }
}
