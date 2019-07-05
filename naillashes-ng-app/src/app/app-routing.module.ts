import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";
import {SigninComponent} from "./app-user/signin/signin.component";
import {SignupComponent} from "./app-user/signup/signup.component";
import {OrderComponent} from "./order/order/order.component";


// noinspection JSAnnotator
const routes: Routes=
[
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent},
  {
    path:'sign-in', component: SigninComponent
  },
  {
    path:'sign-up', component: SignupComponent
  },
  {
    path:'order', component: OrderComponent
  },
  { path: '**', component: PageNotFoundComponent}

];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes),
    CommonModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
