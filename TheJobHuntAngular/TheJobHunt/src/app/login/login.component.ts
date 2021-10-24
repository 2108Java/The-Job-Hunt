import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  currentUser: User = new User(-1, "", "");
  returnUrl: string = "";
  constructor(
    private router: Router,
    private authService: AuthService
  ) { }

  ngOnInit() {
    this.returnUrl = '/home';
    this.authService.logout();
  }

  login() {

    // stop here if form is invalid  
    if (this.currentUser?.email == "admin" && this.currentUser.password == "admin") {
      console.log("Login successful");
      //this.authService.authLogin(this.model);  
      localStorage.setItem('isLoggedIn', "true");
      localStorage.setItem('token', this.currentUser.email);
      this.router.navigate([this.returnUrl]);
    }
    else {
      console.log("Please check your userid and password");
    }
  }
}
