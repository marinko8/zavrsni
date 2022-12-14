import { BetDto } from "./bet-dto";
import { GoalsDto } from "./goals-dto";
import { LeagueDto } from "./league-dto";
import { StatusDto } from "./status-dto";
import { TeamsDto } from "./teams-dto";

export class FootballMatchDto {
    id: Number | undefined;
    type: String | undefined;
    date: Date | undefined;
    teams: TeamsDto | undefined;
    league: LeagueDto | undefined;
  
    status: StatusDto | undefined;
    isLive: Boolean | undefined;
    isOver: Boolean | undefined;
  
    goals: GoalsDto | undefined;
  
    winnerOdds: BetDto | undefined;
    otherOdds: BetDto[] = [];
}
