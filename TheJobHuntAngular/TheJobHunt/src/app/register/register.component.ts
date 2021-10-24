import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { Router } from '@angular/router';
import { UserInformation } from '../UserInformation';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  currentUser: User = new User(-1, "", "");
  currentInfo: UserInformation = new UserInformation(-1,"","","","","", 12345);
  returnUrl: string = "";
  constructor(
    private router: Router
  ) { }

  ngOnInit() {
    this.returnUrl = '/login';
  }

  register():void {

      // stop here if form is invalid  
      if (this.currentUser?.email != "admin") {
        console.log("USER: " + this.currentUser);
        console.log("INFO: " + this.currentInfo)
        this.router.navigate([this.returnUrl]);
      }
      else {
        console.log("Email already exists");
      }
    }

}
