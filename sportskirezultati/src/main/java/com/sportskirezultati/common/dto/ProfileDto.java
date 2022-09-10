package com.sportskirezultati.common.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto for user profile view.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {

  private Long id;
  private String name;
  private String surname;
  private String username;
  private String role;

  private Double points;
  private Integer bankrupt;
  private Integer success;
  private Integer numberOfGames;
  private Integer numberOfFriends;

  private List<BasicUserInfoDto> requestsReceived;
  private List<BasicUserInfoDto> requestsSended;

  private Boolean isFriend;
  private Boolean requestSended;
  private Boolean requestReceived;

  private Boolean banned;
  private LocalDate bannedToDate;

  private List<BetViewDto> bets;
}
