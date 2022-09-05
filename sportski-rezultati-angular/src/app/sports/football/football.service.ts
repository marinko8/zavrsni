import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { FootballMatch } from './dto/football-match';
import { FootballResponse } from './dto/football-response';
import { PlacedBetDto } from './dto/placed-bet-dto';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class FootballService {

  constructor(private httpClient: HttpClient) { }

  getFootballMatchesForToday(): Observable<FootballResponse> {
      return this.httpClient.get<FootballResponse>(environment.baseUrl + '/api/sport/football/data/');
  }

  setNewBet(games: Array<PlacedBetDto>, points: number, odd: number) {
    return this.httpClient.post(environment.baseUrl + '/api/sport/football/setBet', 
        {games: games,
        odd: odd,
        points: points}, httpOptions);
  }

  convertMatchesToMap(list: Array<FootballMatch> | undefined): Map<Number, Array<FootballMatch>> {
    let map: Map<Number, Array<FootballMatch>> = new Map();
    if(list == undefined) {
      return map;
    }

    list.forEach(e => {
      if(e.league?.id != undefined && map.has(e.league?.id)) {
        let leagueMatches: Array<FootballMatch> | undefined = map.get(e.league.id);
        leagueMatches?.push(e);

        if(leagueMatches != undefined) {
          map.set(e.league.id, leagueMatches);
        }
      } else if (e.league?.id != undefined && !map.has(e.league?.id)) {
        map.set(e.league.id, Array.of(e));
      }
    })

    return map;
  }
}