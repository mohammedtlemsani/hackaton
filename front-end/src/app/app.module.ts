import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {ReactiveFormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { SideBarComponent } from './side-bar/side-bar.component';
import { SearchPatientComponent } from './search-patient/search-patient.component';
import { AdminComponent } from './admin/admin.component';
import {AppHttpInterceptor} from "./services/app-http.interceptor";
import { GetPatientComponent } from './get-patient/get-patient.component';
import { ListPatientsComponent } from './list-patients/list-patients.component';
//import { RegisterComponent } from './register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SideBarComponent,
    SearchPatientComponent,
    AdminComponent,
    GetPatientComponent,
    ListPatientsComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule,
        HttpClientModule
    ],
  providers: [ {provide :HTTP_INTERCEPTORS,useClass : AppHttpInterceptor,multi:true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
