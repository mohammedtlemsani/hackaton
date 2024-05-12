import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {PatientService} from "../services/patient.service";

@Component({
  selector: 'app-search-patient',
  templateUrl: './search-patient.component.html',
  styleUrl: './search-patient.component.css'
})
export class SearchPatientComponent implements OnInit{
  patientForm!: FormGroup

  constructor(private fb:FormBuilder,private ps : PatientService) {

  }

  ngOnInit(): void {
    this.patientForm = this.fb.group({
      name: [''], // pat_name
      age: [''], // pat_age
      sex: [''], // pat_sex
      chestPainType: [''], // pat_cp
      restingBloodPressure: [''], // pat_trestbps
      serumCholesterol: [''], // pat_chol
      fastingBloodSugar: [''], // pat_fbs
      restingElectrocardiographicResults: [''], // pat_restecg
      maximumHeartRateAchieved: [''], // pat_thalach
      exerciseInducedAngina: [''], // pat_exang
      stDepressionInducedByExerciseRelativeToRest: [''], // pat_oldpeak
      slopeOfPeakExerciseSTSegment: [''], // pat_slope
      numberOfMajorVesselsColoredByFlourosopy: [''], // pat_ca
      thalassemia: [''], // pat_thal
    });
  }


  handleSubmitPatient() {
    let data = this.patientForm.value
    this.ps.savePatient(data).subscribe({
      next:data=>{
        console.log("done")
        alert("your hash is " + data)
      }
    })
  }
}
