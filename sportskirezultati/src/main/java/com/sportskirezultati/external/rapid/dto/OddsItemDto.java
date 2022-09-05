package com.sportskirezultati.external.rapid.dto;

import com.sportskirezultati.common.dto.BookmakerDto;
import com.sportskirezultati.common.dto.FixtureDto;
import com.sportskirezultati.common.dto.LeagueDto;
import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OddsItemDto {
  private LeagueDto league;
  private FixtureDto fixture;
  private Instant update;
  private List<BookmakerDto> bookmakers;
}
