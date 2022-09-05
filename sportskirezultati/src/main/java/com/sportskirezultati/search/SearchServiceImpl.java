package com.sportskirezultati.search;

import com.sportskirezultati.common.dto.BasicUserInfoDto;
import com.sportskirezultati.domain.userinfo.UserInfoService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link SearchService}.
 */
@Slf4j
@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchService {

  private UserInfoService userInfoService;

  @Override
  public List<BasicUserInfoDto> getUsersByText(String searchText) {
    return userInfoService.search(searchText);
  }
}
