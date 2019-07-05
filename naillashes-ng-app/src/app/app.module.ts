import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import {SignupComponent} from "./app-user/signup/signup.component";
import {SigninComponent} from "./app-user/signin/signin.component";
import {ProfileComponent} from "./app-user/profile/profile.component";
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HeaderComponent } from './header/header.component';
import { NavbarComponent } from './navbar/navbar.component';
import {AuthService} from "./app-auth/service/auth.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ToastrModule} from "ngx-toastr";
import {AppAuthModule} from "./app-auth/app-auth.module";
import {HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { OrderComponent } from './order/order/order.component';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    ProfileComponent,
    SigninComponent,
    HomeComponent,
    PageNotFoundComponent,
    HeaderComponent,
    NavbarComponent,
    OrderComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ToastrModule.forRoot(),
    AppAuthModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule

  ],
  // providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
