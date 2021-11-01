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
    password: ["", [Validators.required]],
    firstname: ["", Validators.required],
    lastname: ["", Validators.required],
    address: ["", Validators.required],
    city: ["", Validators.required],
    state: ["", Validators.required],
    zip: ["", Validators.required]
  });

  ngOnInit() {
    this.returnUrl = '/login';
    this.currentUser = this.dataService.user;
    this.currentUserInfo = this.dataService.userInfo;
  }

  async onSubmit() {
    //no need to make form submission into TS objects;
    // just send raw json/txt (see the discord eg, like in postman)
    // it goes in the body
    if (this.registerform.valid) {

      // let formString = JSON.stringify(this.registerform);
      // let parsedForm = JSON.parse(formString);
      // let unregisteredUser = new User(-1, parsedForm.email, parsedForm.password);
      // let unregisteredInfo = new UserInformation(
      //         -1, 
      //         parsedForm.firstname, 
      //         parsedForm.lastname,
      //         parsedForm.address,
      //         parsedForm.city,
      //         parsedForm.state,
      //         parsedForm.zip);

      this.currentUser = new User(
        -1,
        this.registerform.value.email,
        this.registerform.value.password
      );

      this.currentUserInfo = new UserInformation(
        -1,
        this.registerform.value.firstname,
        this.registerform.value.lastname,
        this.registerform.value.address,
        this.registerform.value.city,
        this.registerform.value.state,
        this.registerform.value.zip
      );

      await this.regService.registerNewUser(this.currentUser).subscribe(
        (data) => {
          console.log(data.body);
          if (data.body != null) {
            this.dataService.user = data.body;
            this.currentUser = data.body;
            console.log(this.currentUser);
            
            }
        }
      );
    }
    this.getNewUserInfo();
  }

  async getNewUserInfo() {
    await this.regService.registerInfoNewUser(this.currentUser, this.currentUserInfo).subscribe(
      (data) => {
        console.log(data.body);
        if (data.status == 200) {
          window.alert('Your registration was successful! Login and get started!');
          
          this.router.navigate([this.returnUrl]);
        }

      }
    );
  }


}