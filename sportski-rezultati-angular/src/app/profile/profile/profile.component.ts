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
  isOwner: Boolean = false;

  constructor(private activateRoute: ActivatedRoute, private profileService: ProfileService, 
    private storageService: StorageService) {
    this.userId = activateRoute.snapshot.params['userId'];
    this.myId = this.storageService.getUser().userId;
    this.myRole = this.storageService.getUser().roles[0];
    this.isOwner = this.userId == this.myId;
   }

  ngOnInit(): void {
    this.profileService.getUserDetails(this.userId).subscribe({
      next: (res) => this.handleSuccessInfoFetch(res),
      error: (e) => console.log("Greska prilikom dohvata podataka")
      
    })
  }

  handleSuccessInfoFetch(res: any) {
    this.userDetails = res;
    if(this.userDetails) {
      this.userDetails.initials = this.userDetails.name!.substring(0, 1) + this.userDetails.surname!.substring(0, 1)
    }
  }

  
  sendRequestAction() {
    this.profileService.sendRequest(this.userId).subscribe({
      next: (res) => window.location.reload(),
      error: (e) => console.log("Greška prilikom izvođenja akcije.")
    })
  }

  cancelRequestAction() {
    this.profileService.cancelRequest(this.userId).subscribe({
      next: (res) => window.location.reload(),
      error: (e) => console.log("Greška prilikom izvođenja akcije.")
    })
  }

  acceptRequestAction() {
    this.profileService.acceptRequest(this.userId).subscribe({
      next: (res) => window.location.reload(),
      error: (e) => console.log("Greška prilikom izvođenja akcije.")
    })
  }

  declineRequestAction() {
    this.profileService.declineRequest(this.userId).subscribe({
      next: (res) => window.location.reload(),
      error: (e) => console.log("Greška prilikom izvođenja akcije.")
    })
  }

  unfriendAction() {
    this.profileService.unfriend(this.userId).subscribe({
      next: (res) => window.location.reload(),
      error: (e) => console.log("Greška prilikom izvođenja akcije.")
    })
  }

  giveModAction() {
    this.profileService.giveMod(this.userId).subscribe({
      next: (res) => window.location.reload(),
      error: (e) => console.log("Greška prilikom izvođenja akcije.")
    })
  }

  removeModAction() {
    this.profileService.removeMod(this.userId).subscribe({
      next: (res) => window.location.reload(),
      error: (e) => console.log("Greška prilikom izvođenja akcije.")
    })
  }

  banUserAction() {
    this.profileService.banUser(this.userId).subscribe({
      next: (res) => window.location.reload(),
      error: (e) => console.log("Greška prilikom izvođenja akcije.")
    })
  }

  disableUserAction() {
    this.profileService.disableUser(this.userId).subscribe({
      next: (res) => window.location.reload(),
      error: (e) => console.log("Greška prilikom izvođenja akcije.")
    })
  }
}
