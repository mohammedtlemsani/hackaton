import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {SearchPatientComponent} from "./search-patient/search-patient.component";
import {AdminComponent} from "./admin/admin.component";
import {GetPatientComponent} from "./get-patient/get-patient.component";
import {ListPatientsComponent} from "./list-patients/list-patients.component";

const routes: Routes = [
  {path : "" ,component: LoginComponent},
  {path : "login",component:LoginComponent},
  {path : "admin",component:AdminComponent , children :[
      {path : "savePatient", component : SearchPatientComponent},
      {path:"getPatient",component:GetPatientComponent},
      {path:"showPatient",component:ListPatientsComponent}
    ]}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
