import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { LoginService } from '../service/login.service';
import { User } from '../models/User';
import { flatten } from '@angular/compiler';
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
    private authService: AuthService,
    private formBuilder: FormBuilder,
    private loginService: LoginService
  ) { }

  ngOnInit() {
   
    this.returnUrl = '/home';
    this.authService.logout();
  }
  loginform = this.formBuilder.group({
    email: ["", [Validators.required, Validators.email]],
    password: ["", Validators.required]
  });

  // this.Form.controls['id'].value;
  user!: User;
  id: number = 0;
  userEmail: String = "";
  userPassword: String = "";
 islogin: boolean = false;
  
 loginV2():void {
     
    this.loginService.loginRequestWithPost(-1, this.loginform.controls['email'].value,
      this.loginform.controls['password'].value).subscribe(
        (data) => {
          console.log(data);
         

          if (data.body != null) {
            console.log("in the body");

            sessionStorage.setItem('isLoggedIn', "true");
            this.router.navigate([this.returnUrl]);           
           
          } 
        }
      );
    
  }


  login() {
    if (this.loginform.valid) {
      this.loginV2()

    } else {
      //fix form
    }
  }
}
