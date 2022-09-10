import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { StorageService } from 'src/app/auth/storage.service';
import { BasicUserInfoDto } from 'src/app/dto/basic-user-info-dto';
import { UserDetails } from 'src/app/dto/user-details';
import { FriendsModalComponent } from '../friends-modal/friends-modal.component';
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
  route: any;

  friends: BasicUserInfoDto[] = [];

  constructor(private activateRoute: ActivatedRoute, private profileService: ProfileService, 
    private storageService: StorageService, private modalService: NgbModal) {
    this.activateRoute.params.subscribe((params: any) => {
        this.paramsChange(params.userId);
    });

    this.myId = this.storageService.getUser().userId;
    this.myRole = this.storageService.getUser().roles[0];
   }

  ngOnInit(): void {
    this.userId = this.activateRoute.snapshot.params['userId'];
    this.isOwner = this.userId == this.myId;

    this.profileService.getUserDetails(this.userId).subscribe({
      next: (res) => this.handleSuccessInfoFetch(res),
      error: (e) => console.log("Greska prilikom dohvata podataka")
    })

    if(this.isOwner) {
      this.profileService.getFriendsList().subscribe({
        next: (res) => this.handleSuccessFriendsFetch(res),
        error: (e) => console.log("Greška prilikom izvođenja akcije")
      })
    } else {
      this.friends = [];
    }
  }

  paramsChange(userId: any) {
    this.userId = this.activateRoute.snapshot.params['userId'];
    this.isOwner = this.userId == this.myId;
    
    this.profileService.getUserDetails(userId).subscribe({
      next: (res) => this.handleSuccessInfoFetch(res),
      error: (e) => console.log("Greska prilikom dohvata podataka")
    })

    if(this.isOwner) {
      this.profileService.getFriendsList().subscribe({
        next: (res) => this.handleSuccessFriendsFetch(res),
        error: (e) => console.log("Greška prilikom izvođenja akcije")
      })
    } else {
      this.friends = [];
    }
  }

  handleSuccessInfoFetch(res: any) {
    this.userDetails = res;
    if(this.userDetails) {
      this.userDetails.initials = this.userDetails.name!.substring(0, 1) + this.userDetails.surname!.substring(0, 1);
    }

    if(this.isOwner && this.userDetails && this.userDetails.requestsReceived) {
      this.userDetails.requestsReceived.forEach(u => u.initials = u.name!.substring(0, 1) + u.surname!.substring(0, 1));
    }

    if(this.isOwner && this.userDetails && this.userDetails.requestsSended) {
      this.userDetails.requestsSended.forEach(u => u.initials = u.name!.substring(0, 1) + u.surname!.substring(0, 1));
    }
  }

  handleSuccessFriendsFetch(res: any) {
    this.friends = res;
  
    if(this.friends) {
      this.friends.forEach(u => u.initials = u.name!.substring(0, 1) + u.surname!.substring(0, 1));
    }
  }

  viewFriends() {
    if(!this.isOwner || this.userDetails?.numberOfFriends == 0) {
      return;
    }


    const friendsModal = this.modalService.open(FriendsModalComponent, {size: 'xl', centered: true, scrollable: true});
    friendsModal.componentInstance.friends = this.friends;
  }

  acceptRequest(userId: any) {
    this.profileService.acceptRequest(userId).subscribe({
      next: (res) => window.location.reload(),
      error: (e) => console.log("Greška prilikom izvođenja akcije.")
    })
  }

  declineRequest(userId: any) {
    this.profileService.declineRequest(userId).subscribe({
      next: (res) => window.location.reload(),
      error: (e) => console.log("Greška prilikom izvođenja akcije.")
    })
  }

  cancelRequest(userId: any) {
    this.profileService.cancelRequest(userId).subscribe({
      next: (res) => window.location.reload(),
      error: (e) => console.log("Greška prilikom izvođenja akcije.")
    })
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
