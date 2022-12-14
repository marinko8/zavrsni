import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { StorageService } from 'src/app/auth/storage.service';
import { BasicUserInfoDto } from 'src/app/dto/basic-user-info-dto';
import { SearchService } from '../search.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Input() page?: string;

  searchForm = new FormGroup({
    searchText: new FormControl('', Validators.required)
  });

  searchResults = false;
  burgerMenuOpen = false;

  searchUsers: Array<BasicUserInfoDto> = [];
  
  loggedInUserId?: number;
  points: number = 0;

  constructor(private searchService: SearchService, private router: Router, private storageService: StorageService) { 
    this.loggedInUserId = this.storageService.getUser().userId;
    this.points = this.storageService.getUser().points;
  }

  ngOnInit(): void {
  }

  search() {
    if(this.searchForm.get('searchText')?.value == "") {
      return;
    }

    this.searchService.search(this.searchForm.get('searchText')?.value).subscribe({
      next: (res) => this.searchUsers = res,
      error: (e) => this.searchUsers = []
    })
    
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
    this.router.navigateByUrl('/profile/' + this.loggedInUserId);
  }

  loadEventsPage(){
    this.router.navigateByUrl('/football');
  }

  loadUser(userId: Number | undefined) {
    if(!userId) {
      return;
    }
    
    this.router.navigateByUrl('/profile/' + userId);
  }

  logout() {
    this.storageService.signOut();
    this.router.navigateByUrl('');
  }
}
