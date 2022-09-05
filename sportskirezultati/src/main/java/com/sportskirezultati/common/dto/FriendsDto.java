package com.sportskirezultati.common.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto for friends list.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FriendsDto {

  private List<BasicUserInfoDto> friends;
}
