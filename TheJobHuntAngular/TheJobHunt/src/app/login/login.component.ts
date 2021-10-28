import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { LoginService } from '../service/login.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  returnUrl: string|any;
  constructor(
    private router: Router,
    private authService: AuthService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    this.returnUrl = '/home';
    this.authService.logout();
  }
  loginform = this.formBuilder.group({
    email: ["", [Validators.required, Validators.email]],
    password: ["", Validators.required]
  });

  login() {
    if (this.loginform.valid) {
      if (true /* check authorization */) {
        //set session information
        sessionStorage.setItem('isLoggedIn', "true");
        this.router.navigate([this.returnUrl]);
      } else {
        // invalid user
      }
    }else {
      //fix form
    }
  }
}
