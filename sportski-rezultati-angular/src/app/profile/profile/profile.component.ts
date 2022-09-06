import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { StorageService } from 'src/app/auth/storage.service';
import { UserDetails } from 'src/app/dto/user-details';
import { ProfileService } from '../profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userId: Number | undefined;
  userDetails: UserDetails | undefined;

  myId: Number = 1;
  myRole: String = "USER";

  constructor(private activateRoute: ActivatedRoute, private profileService: ProfileService, 
    private storageService: StorageService) {
    this.userId = activateRoute.snapshot.params['userId'];
    this.myId = this.storageService.getUser().userId;
    this.myRole = this.storageService.getUser().roles[0];
   }

  ngOnInit(): void {
    this.profileService.getUserDetails(this.userId).subscribe({
      next: (res) => {this.userDetails = res; console.log(this.userDetails);},
      error: (e) => console.log("Greska prilikom dohvata podataka")
      
    })

    if(this.userDetails) {
      this.userDetails.initials = this.userDetails.name!.substring(0, 1) + this.userDetails.surname!.substring(0, 1)
    }
  }

}
