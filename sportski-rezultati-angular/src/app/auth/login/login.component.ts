import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { StorageService } from '../storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });

  hasErrors = false;

  constructor(private router: Router, private authService: AuthService, private storageService: StorageService) { }

  ngOnInit(): void {

  }

  login() {
    // this.router.navigateByUrl('/football');
    this.authService.login(this.loginForm.get('username')?.value, this.loginForm.get('password')?.value).subscribe({
      next: (res) => this.handleSuccessLogin(res),
      error: (e) => this.handleError(e)
    });
  }

  handleSuccessLogin(res: any) {
    this.storageService.saveToken(res.jwtToken);
    this.storageService.saveRefreshToken(res.refreshToken);
    this.storageService.saveUser(res);
    console.log(this.storageService.getUser().username);

    this.router.navigateByUrl('/football');
  }

  handleError(error: any) {
    console.log("ne");
  }

}
