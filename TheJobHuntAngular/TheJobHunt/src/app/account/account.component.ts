import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { User } from '../models/User';
import { UserInformation } from '../models/UserInformation';
import { AccountService } from '../service/account.service';
import { DataService } from '../service/data.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  user!: User;
  userInfo!: UserInformation;
  message!:string|null;
  errorMessage!:string|null;

  constructor(private dataService: DataService, private formBuilder: FormBuilder, private accountService: AccountService) { }
  ngOnInit(): void {
    this.user = this.dataService.currentUser;
    this.userInfo = this.dataService.userInfo
    this.message=null;
    this.errorMessage=null;
  }

  updatedInfoform = this.formBuilder.group({
    email: [this.dataService.currentUser.userEmail, [Validators.required, Validators.email]],
    password: [this.dataService.currentUser.userPassword, Validators.required],
    password2: ["", Validators.required],
    firstname: [this.dataService.userInfo.firstName, Validators.required],
    lastname: [this.dataService.userInfo.lastName, Validators.required],
    address: [this.dataService.userInfo.street, Validators.required],
    city: [this.dataService.userInfo.city, Validators.required],
    state: [this.dataService.userInfo.state, Validators.required],
    zip: [this.dataService.userInfo.zip, Validators.required]
  });

  updateEmail() {
    this.accountService.updateEmail(this.updatedInfoform.get("email")!.value).subscribe(
      (data) => {
        if (data.status == 200) {
          this.message ='Your email was successfully updated!';
        }
      }
    );
  }

  updateInfo() {
    this.accountService.updateInfo(this.updatedInfoform).subscribe(
      (data) => {
        if (data.status == 200) {
          this.message='Your personal information was successfully updated!';
        }
      }
    );
  }

  updatePassword() {
    if(this.updatedInfoform.get("password")!.value == this.updatedInfoform.get("password2")!.value){
      this.accountService.updatePassword(this.updatedInfoform.get("password")!.value).subscribe(
        (data) => {
          if (data.status == 200) {
            this.message='Your password was successfully updated!';
            this.errorMessage=null;
          }
        }
      );
    }else{
      this.message=null;
      this.errorMessage='Password and Password2 are not equal, re-enter Password/Password2'
    }
    
  }

}
