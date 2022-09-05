import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import {Observable} from "rxjs";
import { StorageService } from './auth/storage.service';


@Injectable()
export class AuthenticationGuard implements CanActivate {

    constructor(private storageService: StorageService, private router: Router) {}

    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

        if (this.storageService.getUser()) {
            return true;
        }

        this.router.navigate(['/login']);
        return false;
    }
}
