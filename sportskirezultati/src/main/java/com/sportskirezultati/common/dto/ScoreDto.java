package com.sportskirezultati.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScoreDto {
private GoalsDto halftime;
private GoalsDto fulltime;
private GoalsDto extratime;
private GoalsDto penalty;
}
