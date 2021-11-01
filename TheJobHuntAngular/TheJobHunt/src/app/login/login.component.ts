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
  returnUrl: string | any;
  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private loginService: LoginService,
    private dataService: DataService,
  ) { }

  ngOnInit() {
    this.returnUrl = '/home';
    this.login();
  }
  loginform = this.formBuilder.group({
    email: ["", [Validators.required, Validators.email]],
    password: ["", Validators.required]
  });

  login() {
    if (this.loginform.valid) {
      this.loginService.loginRequestWithPost(this.loginform.controls['email'].value,
        this.loginform.controls['password'].value).subscribe(
          (data) => {
            if (data.body != null) {
              this.dataService.currentUser = data.body;
              sessionStorage.setItem('isLoggedIn', "true");
              console.log(data.headers);
              this.router.navigate([this.returnUrl]);
            }
          }
        );
    } else {
      // this.loginform.validator;
    }
  }
}
