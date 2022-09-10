import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { BasicUserInfoDto } from '../dto/basic-user-info-dto';
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

  getFriendsList() {
    return this.httpClient.get<Array<BasicUserInfoDto>>(environment.baseUrl + '/api/friends/friendsList');
  }

  sendRequest(userId: Number | undefined) {
    return this.httpClient.post<any>(environment.baseUrl + '/api/friends/add?userId=' + userId, {});
  }

  cancelRequest(userId: Number | undefined) {
    return this.httpClient.post<any>(environment.baseUrl + '/api/friends/removeRequest?userId=' + userId, {});
  }

  acceptRequest(userId: Number | undefined) {
    return this.httpClient.post<any>(environment.baseUrl + '/api/friends/accept?userId=' + userId, {});
  }

  declineRequest(userId: Number | undefined) {
    return this.httpClient.post<any>(environment.baseUrl + '/api/friends/decline?userId=' + userId, {});
  }

  unfriend(userId: Number | undefined) {
    return this.httpClient.post<any>(environment.baseUrl + '/api/friends/removeFriend?userId=' + userId, {});
  }

  giveMod(userId: Number | undefined) {
    return this.httpClient.post<any>(environment.baseUrl + '/api/admin/giveMod?userId=' + userId, {});
  }

  removeMod(userId: Number | undefined) {
    return this.httpClient.post<any>(environment.baseUrl + '/api/admin/removeMod?userId=' + userId, {});
  }

  banUser(userId: Number | undefined) {
    return this.httpClient.post<any>(environment.baseUrl + 'api/mod/ban?userId=' + userId, {});
  }

  disableUser(userId: Number | undefined) {
    return this.httpClient.post<any>(environment.baseUrl + '/api/admin/disableUser?userId=' + userId, {});
  }
}
