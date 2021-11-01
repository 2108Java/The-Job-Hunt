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
    email: ["", [Validators.required, Validators.email]],
    password: ["", [Validators.required]],
    firstname: ["", Validators.required],
    lastname: ["", Validators.required],
    address: ["", Validators.required],
    city: ["", Validators.required],
    state: ["", Validators.required],
    zip: ["", Validators.required]
  });
  
 
  // displayAccountInfo() {
  //     this.dataService.getInfoForUser().subscribe(
  //       (data: string) => {
  //         console.log("The data from getInfoForUser is " + data);
  //       });
  }
