import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BasicUserInfoDto } from 'src/app/dto/basic-user-info-dto';
import { SearchService } from '../search.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  searchForm = new FormGroup({
    searchText: new FormControl('', Validators.required)
  });

  activeBets: number = 2;
  searchResults = false;
  burgerMenuOpen = false;

  searchUsers: Array<BasicUserInfoDto> = [];
  
  userId?: number = 5;

  constructor(private searchService: SearchService, private router: Router) { }

  ngOnInit(): void {
  }

  search() {
    if(this.searchForm.get('searchText')?.value == "") {
      return;
    }

    this.searchUsers = this.searchService.search(this.searchForm.get('searchText')?.value);
    this.searchUsers.forEach(u => u.initials = u.name!.substring(0, 1) + u.surname!.substring(0, 1))
    this.searchResults = true;
  }

  cancelSearch() {
    this.searchResults = false;
    this.searchUsers = [];
  }

  toggleMobileMenu() {
    this.burgerMenuOpen = !this.burgerMenuOpen;
  }

  loadMyProfile() {
    this.router.navigateByUrl('/profile/' + this.userId);
  }

  loadUser(userId: Number | undefined) {
    if(!userId) {
      return;
    }
    
    this.router.navigateByUrl('/profile/' + userId);
  }
}
