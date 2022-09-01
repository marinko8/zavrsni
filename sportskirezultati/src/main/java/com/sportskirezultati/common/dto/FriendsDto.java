package com.sportskirezultati.common.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * Dto for friends list.
 */
@Data
@Builder
public class FriendsDto {

  private List<BasicUserInfoDto> friends;
}
