import { Injectable } from '@angular/core';

const TOKEN= 'token';
const REFRESHTOKEN = 'refreshtoken';
const USER = 'auser';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() { }

  signOut(): void {
    window.sessionStorage.clear();
  }

  public saveToken(token: string): void {
    window.sessionStorage.removeItem(TOKEN);
    window.sessionStorage.setItem(TOKEN, token);

    const user = this.getUser();
    if (user.id) {
      this.saveUser({ ...user, accessToken: token });
    }
  }

  public getToken(): string | null {
    return window.sessionStorage.getItem(TOKEN);
  }

  public saveRefreshToken(token: string): void {
    window.sessionStorage.removeItem(REFRESHTOKEN);
    window.sessionStorage.setItem(REFRESHTOKEN, token);
  }

  public getRefreshToken(): string | null {
    return window.sessionStorage.getItem(REFRESHTOKEN);
  }

  public saveUser(user: any): void {
    window.sessionStorage.removeItem(USER);
    window.sessionStorage.setItem(USER, JSON.stringify(user));
  }

  public getUser(): any {
    const user = window.sessionStorage.getItem(USER);
    if (user) {
      return JSON.parse(user);
    }

    return {};
  }
}
