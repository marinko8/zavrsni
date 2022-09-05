package com.sportskirezultati.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScoreDto {
private GoalsDto halftime;
private GoalsDto fulltime;
private GoalsDto extratime;
private GoalsDto penalty;
}
