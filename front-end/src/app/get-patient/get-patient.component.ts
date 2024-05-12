import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {PatientService} from "../services/patient.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-get-patient',
  templateUrl: './get-patient.component.html',
  styleUrl: './get-patient.component.css'
})
export class GetPatientComponent implements OnInit{
  patientForm!: FormGroup;
  constructor(private fb : FormBuilder,private ps:PatientService,private router : Router) {
  }


  ngOnInit(): void {
    this.patientForm = this.fb.group({
      hash:[""],
      secretKey:[""]
    }
  )
  }
  handlegetPatient() {
    var patientHash = this.patientForm.value.hash
    this.router.navigateByUrl("/admin/showPatient")
    this.ps.getPatient(patientHash).subscribe({
      next:data=>{

      }
    })

  }
}
