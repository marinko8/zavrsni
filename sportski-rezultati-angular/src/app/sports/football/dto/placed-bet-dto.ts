import { TeamsDto } from "./teams-dto";

export class PlacedBetDto {
    fixtureId: Number | undefined;
    teams: TeamsDto | undefined;
    leagueId: Number | undefined;
    type: String | undefined;
    odd: Number | undefined;
    value: String | undefined;
}
