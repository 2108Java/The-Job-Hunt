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
  ngOnInit(): void {
    
  }




  updatedInfoform = this.formBuilder.group({
    email: [this.dataService.user.email, [Validators.required, Validators.email]],
    password: [this.dataService.user.password, Validators.required],
    firstname: [this.dataService.userInfo.firstName, Validators.required],
    lastname: [this.dataService.userInfo.lastName, Validators.required],
    address: [this.dataService.userInfo.street, Validators.required],
    city: [this.dataService.userInfo.city, Validators.required],
    state: [this.dataService.userInfo.state, Validators.required],
    zip: [this.dataService.userInfo.zip, Validators.required]
  });
  
 
  // displayAccountInfo() {
  //     this.dataService.getInfoForUser().subscribe(
  //       (data: string) => {
  //         console.log("The data from getInfoForUser is " + data);
  //       });
  }
