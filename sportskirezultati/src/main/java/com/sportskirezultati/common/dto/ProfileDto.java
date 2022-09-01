package com.sportskirezultati.common.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * Dto for user profile view.
 */
@Data
@Builder
public class ProfileDto {

  private BasicUserInfoDto basicInfo;

  private Integer numberOfBets;
  private Double points;
  private Integer bankrupts;

  private Integer numberOfFriends;

  private boolean requestSent;
  private boolean requestReceived;

  private List<BetViewDto> lastFinishedBets;

  private List<BetViewDto> activeBets;
  private List<BasicUserInfoDto> friendRequests;
}
