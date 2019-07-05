import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {first, map} from "rxjs/operators";
import {AuthService} from "../../app-auth/service/auth.service";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";



@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  registerForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private authService: AuthService, private router: Router, private toastr: ToastrService ) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(4)]],
      surname: ['', [Validators.required, Validators.minLength(4)]],
      email: [
        '',
        // [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")],
        // this.validateEmailNotTaken.bind(this)
      ],
      password: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(20)]],
      phoneNumber: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(15)]]
    })



  }



  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onFormSubmit() {
    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }
    this.authService.register(this.registerForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.toastr.success("Thank you! You're successfully registered. Please Login to continue!"); // zeby t poszlo muusi myc
          ///////////////  BrowserAnimationsModule from "@angular/platform-browser/animations"
          this.router.navigate(['/sign-in']);
        }
        // ,
        // error => {
        //   this.alertService.error(error || "Sorry! Something went wrong. Please try again!");
        // }

        );
  }

  // validateUsernameAvailability(control: AbstractControl) {
  //   return this.authService.checkUsernameAvailability(control.value).pipe(map(res => {
  //     return res.available ? null : { usernameTaken: true };
  //   }));
  // }

  validateEmailNotTaken(control: AbstractControl) {
    return this.authService.checkEmailAvailability(control.value).pipe(map(res => {
      return res.available ? null : { emailTaken: true };
    }));
  }


}
