import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { BasicUserInfoDto } from '../dto/basic-user-info-dto';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private httpClient: HttpClient) { }

  search(text: string | undefined | null): Observable<Array<BasicUserInfoDto>> {
    return this.httpClient.get<Array<BasicUserInfoDto>>(environment.baseUrl + "/api/search?=" + text);
  }
}
