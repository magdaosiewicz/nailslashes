import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../app-auth/service/auth.service";
import {Router} from "@angular/router";
import {pipe} from "rxjs/internal-compatibility";
import {first} from "rxjs/operators";
import {Observable} from "rxjs/internal/Observable";

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  loginForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
  }


  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    })

    // this.authService.login(this.loginForm.value)
  }


  get formControl() {
    return this.loginForm.controls;
  }

  onSumbit() {
    if (this.loginForm.invalid)
      return;

    this.authService.login(this.formControl.email.value, this.formControl.password.value)
      .pipe(first())
      .subscribe(
       () => this.router.navigate(['/'])
      //   ,
      //   error => {
      //     this.alertService.error(error);
      //   }
      );

  }

}
