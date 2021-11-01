import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { User } from '../models/User';
import { UserInformation } from '../models/UserInformation';
import { DataService } from '../service/data.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  private user!: User;
  private userInfo!: UserInformation;

  constructor(private dataService: DataService, private formBuilder: FormBuilder) { }

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
  
  onSubmit(){
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
        });
      

  displayAccountInfo(){
  this.dataService.getInfoForUser().subscribe(
    (data) => {
      console.log("The data from getInfoForUser is " + data);
    });
  }


  ngOnInit(): void {
    this.dataService.getInfoForUser();
  }

}
}

function displayAccountInfo() {
    throw new Error('Function not implemented.');
  }
