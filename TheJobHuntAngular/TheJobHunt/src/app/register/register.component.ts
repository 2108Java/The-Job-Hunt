import { Component, Input, OnInit } from '@angular/core';
import { User } from '../User';
import { Router } from '@angular/router';
import { UserInformation } from '../UserInformation';
import { EmailValidator, FormBuilder, Validators, FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  returnUrl: string = "";
  formSumitAttempt: boolean = false;
  @Input() errorMsg: string = "";
  @Input() displayError: boolean = false;

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
  ) { }

  registerform = this.formBuilder.group({
    email: [null, [Validators.required, Validators.email]],
    firstname: [null, Validators.required],
    lastname: [null, Validators.required],
    address: [null, Validators.required],
    city: [null, Validators.required],
    state: [null, Validators.required],
    zip: [null, Validators.required]
  });

  ngOnInit() {
    this.returnUrl = '/login';
  }

  isFieldValid(field: string) {
    return !this.registerform.get(field)!.valid && this.registerform.get(field)!.touched;
  }

  displayFieldCss(field: string) {
    return {
      'has-error': this.isFieldValid(field),
      'has-feedback': this.isFieldValid(field)
    };
  }

  onSubmit() {
    console.log(this.registerform);
    if (this.registerform.valid) {
      console.log('form submitted');
    } else {
      this.validateAllFormFields(this.registerform);
    }
  }

  validateAllFormFields(formGroup: FormGroup) {
    Object.keys(formGroup.controls).forEach(field => {
      console.log(field);
      const control = formGroup.get(field);
      if (control instanceof FormControl) {
        control.markAsTouched({ onlySelf: true });
      } else if (control instanceof FormGroup) {
        this.validateAllFormFields(control);
      }
    });
  }

  reset() {
    this.registerform.reset();
    this.formSumitAttempt = false;
  }

  }
