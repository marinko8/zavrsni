package com.sportskirezultati.search;

import com.sportskirezultati.common.dto.BasicUserInfoDto;
import java.util.List;

/**
 * Service for fetching search data.
 */
public interface SearchService {

  /**
   * Find users by search text.
   */
  public List<BasicUserInfoDto> getUsersByText(String searchText);
}
