import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { BasicUserInfoDto } from 'src/app/dto/basic-user-info-dto';
import { ProfileService } from '../profile.service';

@Component({
  selector: 'app-friends-modal',
  templateUrl: './friends-modal.component.html',
  styleUrls: ['./friends-modal.component.css']
})
export class FriendsModalComponent implements OnInit {
  @Input() public friends: BasicUserInfoDto[] = [];

  constructor(public activeModal: NgbActiveModal, private profileService: ProfileService,  private router: Router) { }

  ngOnInit(): void {
    this.profileService.getFriendsList().subscribe({
      next: (res) => this.handleSuccessFetch(res),
      error: (e) => console.log("Greška prilikom izvođenja akcije")
    })
  }

handleSuccessFetch(res: any) {
  this.friends = res;

  if(this.friends) {
    this.friends.forEach(u => u.initials = u.name!.substring(0, 1) + u.surname!.substring(0, 1));
  }
}

  
unfriend(userId: any) {
  this.profileService.unfriend(userId).subscribe({
    next: (res) => window.location.reload(),
    error: (e) => console.log("Greška prilikom izvođenja akcije.")
  })
}

view(userId: any) {
  this.router.navigateByUrl('/profile/' + userId);
  this.activeModal.close();
}
}
