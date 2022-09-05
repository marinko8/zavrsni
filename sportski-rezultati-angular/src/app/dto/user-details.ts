import { BetSummary } from "./bet-summary";

export class UserDetails {
    id: Number | undefined;
    name: String | undefined;
    surname: String | undefined;
    username: String | undefined;
    role: String | undefined;
    initials?: String | undefined;
    points: Number | undefined;
    bankrupt: Number | undefined;
    success: Number | undefined;
    numberOfGames: Number | undefined;
    numberOfFriends: Number | undefined;

    isFriend?: Boolean | undefined;
    requestSended?: Boolean | undefined;
    requestReceived?: Boolean | undefined;
    
    banned?: Boolean | undefined;
    bannedToDate?: Date | undefined;

    bets?: BetSummary[] = [];
}
