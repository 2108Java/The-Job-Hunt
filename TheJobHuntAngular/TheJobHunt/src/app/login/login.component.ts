import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { LoginService } from '../service/login.service';
import { DataService } from '../service/data.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  returnUrl!: string;
  message!: string | null;
  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private loginService: LoginService,
    private dataService: DataService,
  ) { }

  ngOnInit() {
    this.returnUrl = '/home';
  }

  loginform = this.formBuilder.group({
    email: ["", [Validators.required, Validators.email]],
    password: ["", Validators.required]
  });

  login() {
    this.message = null;
    if (this.loginform.valid) {
      this.loginService.loginRequestWithPost(this.loginform.controls['email'].value,
        this.loginform.controls['password'].value).subscribe(
          (data) => {
            if (data.body != null) {
              this.dataService.currentUser = data.body;
              sessionStorage.setItem('isLoggedIn', "true");
              this.router.navigate([this.returnUrl]);
            }else{
              this.message = "Cannot find email or password, try re-entering email/password."
            }
          }
        );
    } else {
      this.message = "Invalid form input, fix form and try logging in aggain."
    }
  }
}
