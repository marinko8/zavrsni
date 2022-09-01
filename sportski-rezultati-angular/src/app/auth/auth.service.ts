import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { RegisterRequestDto } from '../aauth/dto/register-request-dto';
import { LoginResponseDto } from './dto/login-response-dto';
import { StorageService } from './storage.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private httpClient: HttpClient, private storageService: StorageService) { }


  login(username: string | any, password: string | any): Observable<any> {
    return this.httpClient.post(environment.baseUrl + '/api/auth/signin', {
      username,
      password
    }, httpOptions);
  }

  register(registerRequest: RegisterRequestDto): Observable<any> {
    return this.httpClient.post(environment.baseUrl + '/api/auth/signup', registerRequest, httpOptions);
  }

  refreshToken(token: string) {
    return this.httpClient.post(environment.baseUrl + '/api/auth/refreshtoken', {
      refreshToken: token
    }, httpOptions);
  }
}

