import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterRequestDto } from 'src/app/aauth/dto/register-request-dto';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signUpForm: FormGroup = new FormGroup({
    name: new FormControl('', Validators.required),
    surname: new FormControl('', Validators.required),
    username: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });;

  constructor(private router: Router, private authService: AuthService) { }


  ngOnInit(): void {

  }

  
  signUp() {
    let requestDto: RegisterRequestDto = {name: this.signUpForm.get('name')?.value,
    surname: this.signUpForm.get('surname')?.value,
    username: this.signUpForm.get('username')?.value,
    email: this.signUpForm.get('email')?.value,
    password: this.signUpForm.get('password')?.value,
  };
    this.authService.register(requestDto).subscribe(res => {
      console.log(res);
      
      if (res.errors.length == 0) {
        this.router.navigateByUrl('/login');
      } else {
        console.log("greska");
        
      }
    });
  }

  cancel() {
    this.router.navigateByUrl('');
  }
}
