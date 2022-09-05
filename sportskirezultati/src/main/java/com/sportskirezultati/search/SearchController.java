package com.sportskirezultati.search;

import com.sportskirezultati.common.EndpointUrls;
import com.sportskirezultati.common.dto.BasicUserInfoDto;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for user profile requests.
 */
@RestController
@AllArgsConstructor
@RequestMapping(EndpointUrls.SEARCH_API)
public class SearchController {

  private final SearchService searchService;

  @GetMapping()
  public ResponseEntity<List<BasicUserInfoDto>> getUserProfile(@RequestParam String text) {
    return ResponseEntity.ok(searchService.getUsersByText(text));
  }
}
