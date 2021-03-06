import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { DataService } from '../service/data.service';
import { User } from '../models/User';
import { UserInformation } from '../models/UserInformation';
import { RegisterService } from '../service/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  returnUrl: string | any;
  currentUser!: User;
  currentUserInfo!: UserInformation;

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private dataService: DataService,
    private regService: RegisterService
  ) { }

  registerform = this.formBuilder.group({
    email: ["", [Validators.required, Validators.email]],
    firstname: ["", Validators.required],
    lastname: ["", Validators.required],
    address: ["", Validators.required],
    city: ["", Validators.required],
    state: ["", Validators.required],
    zip: ["", Validators.required]
  });

  ngOnInit() {
    this.returnUrl = '/login';
    this.currentUser = this.dataService.currentUser;
    this.currentUserInfo = this.dataService.userInfo;
  }

  async onSubmit() {
    if (this.registerform.valid) {

      this.currentUserInfo = new UserInformation(
        -1,
        this.registerform.value.firstname,
        this.registerform.value.lastname,
        this.registerform.value.address,
        this.registerform.value.city,
        this.registerform.value.state,
        this.registerform.value.zip
      );

      await this.regService.registerNewUser(this.registerform.value.email).subscribe(
        (data) => {
          if (data.body != null) {
            this.dataService.currentUser = data.body;
            this.currentUser = data.body;
            this.regService.registerInfoNewUser(this.currentUserInfo).subscribe(
              (data) => {
                if (data.status == 200) {
                  window.alert('Your registration was successful! Login and get started!');
                  this.router.navigate([this.returnUrl]);
                }
              }
            );
          }
        }
      );
    }
  }
}