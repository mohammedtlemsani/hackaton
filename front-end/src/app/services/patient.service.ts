import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http : HttpClient) { }
  savePatient(data: any) {
  return this.http.post("http://localhost:8080/upload",data)
  }

  getPatient(patientHash: any) {
    return this.http.get("http://localhost:8080/file/"+patientHash);
  }
}
