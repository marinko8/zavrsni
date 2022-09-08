import { Component, OnInit } from '@angular/core';
import { StorageService } from 'src/app/auth/storage.service';
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

  userPoints: number = 0
  betPoints?: number;
  oddsSum: number = 0;

  betsPlaced: Array<PlacedBetDto> = [];

  constructor(private footballService: FootballService, private storageService: StorageService) { }

  ngOnInit(): void {
    this.userPoints = this.storageService.getUser().points;
    this.footballService.getFootballMatchesForToday().subscribe({
      next: (res) => this.handleSuccessFetch(res),
      error: (e) => console.log("Dogodila se pogreška prilikom dohvata podataka")
      
    });
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
        type: "01",
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
    if(!this.betPoints || this.betPoints < 10 || this.betPoints > this.userPoints) {
      return;
    }

    this.footballService.setNewBet(this.betsPlaced, this.betPoints, this.oddsSum).subscribe({
      next: (res) => window.location.reload(),
      error: (e) => console.log("Greška prilikom postavljanja nove igre")
      
    })
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

  handleSuccessFetch(res: any) {
    this.matchesResponse = res;
    
    this.leaguesMap = this.footballService.convertMatchesToMap(this.matchesResponse?.events);
  }
}
