import { Component, OnInit } from '@angular/core';
import { FootballMatch } from '../dto/football-match';
import { FootballResponse } from '../dto/football-response';
import { PlacedBetDto } from '../dto/placed-bet-dto';
import { FootballService } from '../football.service';

@Component({
  selector: 'app-football',
  templateUrl: './football.component.html',
  styleUrls: ['./football.component.css']
})
export class FootballComponent implements OnInit {
  matchesResponse: FootballResponse | undefined;
  leaguesMap: Map<Number, Array<FootballMatch>> = new Map();

  betPoints: number = 0;
  oddsSum: number = 0;

  betsPlaced: Array<PlacedBetDto> = [];

  constructor(private footballService: FootballService) { }

  ngOnInit(): void {
    this.matchesResponse = this.footballService.getFootballMatchesForToday();
    this.leaguesMap = this.footballService.convertMatchesToMap(this.matchesResponse.events);
    if(this.matchesResponse.events[0].goals) {
      this.matchesResponse.events[0].goals.home = 3;
    }
  }

  chooseWinner(fixtureId?: Number, value?: String) {
    let match: FootballMatch | undefined = this.matchesResponse?.events.find(e => e.id == fixtureId);
    if(!match) {
      return;
    }

    let betIndex = this.betsPlaced.findIndex(b => b.fixtureId == fixtureId);
    let odd = match.winnerOdds?.values.find(v => v.value == value)?.odd;

    if(!match.winnerOdds?.selected) {
      match.winnerOdds!.selected = value;

      this.betsPlaced.push({
        fixtureId: match.id,
        teams: match.teams,
        leagueId: match.league?.id,
        odd: odd,
        value: value
      });
    }else if(match.winnerOdds?.selected == value) {
      match.winnerOdds!.selected = undefined;      
      
      this.betsPlaced.splice(betIndex, 1);
      
    } else {
      match.winnerOdds!.selected = value;

      this.betsPlaced[betIndex].odd = odd;
      this.betsPlaced[betIndex].value = value;
    }

    this.calculateOdds();
  }

  removeByIndex(index: number) {
    let fixtureId = this.betsPlaced[index].fixtureId;

    this.betsPlaced.splice(index, 1);

    let match: FootballMatch | undefined = this.matchesResponse?.events.find(e => e.id == fixtureId);
    if(!match) {
      return;
    }

    match.winnerOdds!.selected = undefined;

    this.calculateOdds();
  }

  removeAll() {
    do {
      this.removeByIndex(0);
    } while(this.betsPlaced.length > 0);
  }

  confirm() {

  }

  calculateOdds() {
    let odds = 1;
    this.betsPlaced.forEach(b => {
      if(b.odd) {
        odds = b.odd.valueOf() * odds
      }
    });

    this.oddsSum = odds;
  }
}