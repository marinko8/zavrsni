import { Injectable } from '@angular/core';
import { BetSummary } from '../dto/bet-summary';
import { UserDetails } from '../dto/user-details';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor() { }

  getUserDetails(userId: Number | undefined) {
    let bets: BetSummary[] = [
      {
        date: "29.8.2022",
        betsCount: 4,
        winningBets: 1,
        totalOdd: 11.2,
        points: 50,
        pointsToWin: 560,
        isActive: true
      },
      {
        date: "29.8.2022",
        betsCount: 8,
        winningBets: 7,
        totalOdd: 52,
        points: 50,
        pointsToWin: 2600,
        isActive: true
      },
      {
        date: "29.8.2022",
        betsCount: 4,
        winningBets: 2,
        totalOdd: 12.2,
        points: 100,
        pointsToWin: 1220,
        isActive: true
      },
      {
        date: "29.8.2022",
        betsCount: 10,
        winningBets: 2,
        totalOdd: 53.7,
        points: 50,
        pointsToWin: 2685,
        isActive: true
      },
      {
        date: "27.8.2022",
        betsCount: 8,
        winningBets: 8,
        totalOdd: 20.2,
        points: 100,
        pointsToWin: 2020,
        isActive: false
      },
      {
        date: "27.8.2022",
        betsCount: 5,
        winningBets: 4,
        totalOdd: 19.6,
        points: 50,
        pointsToWin: 980,
        isActive: false
      },
      {
        date: "26.8.2022",
        betsCount: 6,
        winningBets: 2,
        totalOdd: 30.1,
        points: 80,
        pointsToWin: 2408,
        isActive: false
      },
      {
        date: "24.8.2022",
        betsCount: 3,
        winningBets: 3,
        totalOdd: 10.1,
        points: 50,
        pointsToWin: 505,
        isActive: false
      },
      {
        date: "24.8.2022",
        betsCount: 6,
        winningBets: 4,
        totalOdd: 23.0,
        points: 60,
        pointsToWin: 1380,
        isActive: false
      },
      {
        date: "23.8.2022",
        betsCount: 5,
        winningBets: 5,
        totalOdd: 17.4,
        points: 50,
        pointsToWin: 870,
        isActive: false
      },];

    let userDetails: UserDetails = {
      id: userId,
      name: "Niko",
      surname: "Horvat",
      username: "nHorvat",
      role: "USER",
      points: 3648,
      bankrupt: 1,
      success: 41,
      numberOfGames: 10,
      numberOfFriends: 61,
      isFriend: false,
      requestReceived: false,
      requestSended: false,
      banned: false,
      bannedToDate: undefined,
      bets: bets
    }

    return userDetails;
  }
}
