import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthenticationGuard } from './auth.guard';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { HomeComponent } from './home/home/home.component';
import { ProfileComponent } from './profile/profile/profile.component';
import { FootballComponent } from './sports/football/football/football.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'signUp', component: SignupComponent},
  {path: 'login', component: LoginComponent},
  {path: 'football', component: FootballComponent, canActivate: [AuthenticationGuard]},
  {path: 'profile/:userId', component: ProfileComponent, canActivate: [AuthenticationGuard] }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
