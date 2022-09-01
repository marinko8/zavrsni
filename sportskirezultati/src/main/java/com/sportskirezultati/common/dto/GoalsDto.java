package com.sportskirezultati.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoalsDto {
private Integer home;
private Integer away;
}
