import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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

  constructor(private activateRoute: ActivatedRoute, private profileService: ProfileService) {
    this.userId = activateRoute.snapshot.params['userId'];
   }

  ngOnInit(): void {
    this.userDetails = this.profileService.getUserDetails(this.userId);
    this.userDetails.initials = this.userDetails.name!.substring(0, 1) + this.userDetails.surname!.substring(0, 1)
  }

}
