package com.sportskirezultati.sport.football;

import com.sportskirezultati.auth.UserDetailsImpl;
import com.sportskirezultati.common.EndpointUrls;
import com.sportskirezultati.common.dto.BusinessResponse;
import com.sportskirezultati.common.dto.EventsDto;
import com.sportskirezultati.common.dto.football.FootballBet;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for user profile requests.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(EndpointUrls.FOOTBALL_EVENTS_API)
public class FootballBetsController {

  private final FootballBetsService footballBetsService;

  @GetMapping(EndpointUrls.FOOTBALL_DATA)
  public ResponseEntity<EventsDto> getFootballEvents(
      @RequestParam(required = false, defaultValue = "#{T(java.time.LocalDate).now()}") LocalDate date) {
    return ResponseEntity.ok(footballBetsService.fetchEventsForDate(date));
  }

  @PostMapping(EndpointUrls.SET_BET)
  public ResponseEntity<BusinessResponse> getFootballEvents(Authentication authentication,
      @RequestBody FootballBet bet) {
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    return ResponseEntity.ok(footballBetsService.setBet(userDetails.getId(), bet));
  }
}
