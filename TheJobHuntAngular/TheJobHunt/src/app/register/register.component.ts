import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { DataService } from '../service/data.service';
import { User } from '../models/User';
import { UserInformation } from '../models/UserInformation';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  returnUrl: string | any;

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private dataService: DataService
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
  }

  onSubmit() {
    if (this.registerform.valid) {
      
      let formString = JSON.stringify(this.registerform);
      let parsedForm = JSON.parse(formString);
      let unregisteredUser = new User(-1, parsedForm.email, parsedForm.password);
      let unregisteredInfo = new UserInformation(
              -1, 
              parsedForm.firstname, 
              parsedForm.lastname,
              parsedForm.address,
              parsedForm.city,
              parsedForm.state,
              parsedForm.zip);
      this.dataService.registerInfoNewUser(unregisteredUser, unregisteredInfo).subscribe(
        (data) => {
          let registration: UserInformation = data;
          console.log(registration);
        }
      );
      this.router.navigate([this.returnUrl]);
    }
  }
}
