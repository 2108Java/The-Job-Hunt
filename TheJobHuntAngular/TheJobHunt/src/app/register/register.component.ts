import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';

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
  }

  onSubmit() {
    if (this.registerform.valid) {
      //register user in register service
      this.router.navigate([this.returnUrl]);
    }
  }
}
