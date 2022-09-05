import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { BetSummary } from '../dto/bet-summary';
import { UserDetails } from '../dto/user-details';
import { FootballResponse } from '../sports/football/dto/football-response';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private httpClient: HttpClient) { }

  getUserDetails(userId: Number | undefined) {
    return this.httpClient.get<UserDetails>(environment.baseUrl + '/api/profile/profile?userId=' + userId);
  }
}
