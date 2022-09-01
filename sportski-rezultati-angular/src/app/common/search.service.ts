import { Injectable } from '@angular/core';
import { BasicUserInfoDto } from '../dto/basic-user-info-dto';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor() { }

  search(text: string | undefined | null): Array<BasicUserInfoDto> {
    if(!text) {
      return [];
    }

    let user1: BasicUserInfoDto = {id: 1,
                                  name: "Petar",
                                  surname: "Horvat",
                                  username: "pHorvat"};
    let user2: BasicUserInfoDto = {id: 2,
                                  name: "Niko",
                                  surname: "Horvat",
                                  username: "nHorvat"}
    return[user1, user2];
  }
}
