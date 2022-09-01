import { Injectable } from '@angular/core';
import { FootballMatch } from './dto/football-match';
import { FootballResponse } from './dto/football-response';

@Injectable({
  providedIn: 'root'
})
export class FootballService {

  constructor() { }

  getFootballMatchesForToday(): FootballResponse {
    let match1: FootballMatch = {
      id: 1,
      type: '1',
      date: Date.now(),
      teams: {home: {id: 1,
                    name: "Liverpool",
                    logo: "https://media.api-sports.io/football/teams/40.png",
                    winner: false},
              away: {id: 2,
                    name: "Leicester",
                    logo: "https://media.api-sports.io/football/teams/46.png",
                    winner: false}},
      league: {id: 1,
              name: "Premier League",
              country: "England",
              logo: "https://media.api-sports.io/football/leagues/39.png",
              flag: "https://media.api-sports.io/flags/gb.svg",
              season: 2022},
      status: {long: "Second half",
              short: "SH",
              elapsed: 81,
              seconds: undefined},
      isLive: true,
      isOver: false,
      goals: {home: 4,
              away: 2},
      winnerOdds: {id: 1,
                  name: "Full time result",
                  values: [{value: "1",
                            odd: 1.4,
                            handicap: undefined,
                            main: undefined,
                            suspended: undefined},
                           {value: "X",
                            odd: 2.4,
                            handicap: undefined,
                            main: undefined,
                            suspended: undefined},
                           {value: "2",
                            odd: 3.4,
                            handicap: undefined,
                            main: undefined,
                            suspended: undefined}]},
      otherOdds: []};

      let match2: FootballMatch = {
        id: 2,
        type: '1',
        date: Date.now(),
        teams: {home: {id: 3,
                      name: "AC Milan",
                      logo: "https://media.api-sports.io/football/teams/489.png",
                      winner: false},
                away: {id: 4,
                      name: "Inter",
                      logo: "https://media.api-sports.io/football/teams/505.png",
                      winner: false}},
        league: {id: 2,
                name: "Seria A",
                country: "Italy",
                logo: "https://media.api-sports.io/football/leagues/135.png",
                flag: "https://media.api-sports.io/flags/it.svg",
                season: 2022},
        status: {long: "Second half",
                short: "SH",
                elapsed: 49,
                seconds: undefined},
        isLive: true,
        isOver: false,
        goals: {home: 2,
                away: 1},
        winnerOdds: {id: 1,
                    name: "Full time result",
                    values: [{value: "1",
                              odd: 2.9,
                              handicap: undefined,
                              main: undefined,
                              suspended: undefined},
                             {value: "X",
                              odd: 2.9,
                              handicap: undefined,
                              main: undefined,
                              suspended: undefined},
                             {value: "2",
                              odd: 2.0,
                              handicap: undefined,
                              main: undefined,
                              suspended: undefined}]},
        otherOdds: []};
      
        let match3: FootballMatch = {
          id: 3,
          type: '1',
          date: Date.now(),
          teams: {home: {id: 5,
                        name: "Wolves",
                        logo: "https://media.api-sports.io/football/teams/39.png",
                        winner: false},
                  away: {id: 6,
                        name: "Chelsea",
                        logo: "https://media.api-sports.io/football/teams/49.png",
                        winner: false}},
          league: {id: 1,
                  name: "Premier League",
                  country: "England",
                  logo: "https://media.api-sports.io/football/leagues/39.png",
                  flag: "https://media.api-sports.io/flags/gb.svg",
                  season: 2022},
          status: {long: "First half",
                  short: "FH",
                  elapsed: 20,
                  seconds: undefined},
          isLive: true,
          isOver: false,
          goals: {home: 1,
                  away: 0},
          winnerOdds: {id: 1,
                      name: "Full time result",
                      values: [{value: "1",
                                odd: 1.4,
                                handicap: undefined,
                                main: undefined,
                                suspended: undefined},
                               {value: "X",
                                odd: 2.4,
                                handicap: undefined,
                                main: undefined,
                                suspended: undefined},
                               {value: "2",
                                odd: 3.4,
                                handicap: undefined,
                                main: undefined,
                                suspended: undefined}]},
          otherOdds: []};

          let match4: FootballMatch = {
            id: 4,
            type: '1',
            date: Date.now(),
            teams: {home: {id: 7,
                          name: "Napoli",
                          logo: "https://media.api-sports.io/football/teams/492.png",
                          winner: false},
                    away: {id: 8,
                          name: "Lazio",
                          logo: "https://media.api-sports.io/football/teams/487.png",
                          winner: false}},
            league: {id: 2,
                    name: "Seria A",
                    country: "Italy",
                    logo: "https://media.api-sports.io/football/leagues/135.png",
                    flag: "https://media.api-sports.io/flags/it.svg",
                    season: 2022},
            status: {long: "First half",
                    short: "2H",
                    elapsed: 42,
                    seconds: undefined},
            isLive: true,
            isOver: false,
            goals: {home: 0,
                    away: 0},
            winnerOdds: {id: 1,
                        name: "Full time result",
                        values: [{value: "1",
                                  odd: 2.9,
                                  handicap: undefined,
                                  main: undefined,
                                  suspended: undefined},
                                 {value: "X",
                                  odd: 2.9,
                                  handicap: undefined,
                                  main: undefined,
                                  suspended: undefined},
                                 {value: "2",
                                  odd: 2.0,
                                  handicap: undefined,
                                  main: undefined,
                                  suspended: undefined}]},
            otherOdds: []};

    let response: FootballResponse = {events: [match4, match3, match2, match1]};

    return response;
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