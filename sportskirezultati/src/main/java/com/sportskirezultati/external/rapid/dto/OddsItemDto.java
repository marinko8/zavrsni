package com.sportskirezultati.external.rapid.dto;

import com.sportskirezultati.common.dto.BookmakerDto;
import com.sportskirezultati.common.dto.FixtureDto;
import com.sportskirezultati.common.dto.LeagueDto;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OddsItemDto {
  private LeagueDto league;
  private FixtureDto fixture;
  private LocalDateTime update;
  private List<BookmakerDto> bookmakers;
}
