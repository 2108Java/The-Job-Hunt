import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { tap, delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor() { }
  logout(): void {
    sessionStorage.setItem('isLoggedIn', 'false');
    sessionStorage.removeItem('token');
  }
}
