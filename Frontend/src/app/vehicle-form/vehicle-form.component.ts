import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-vehicle-form',
  templateUrl: './vehicle-form.component.html',
  styleUrls: ['./vehicle-form.component.css']
})
export class VehicleFormComponent implements OnInit {
  driverInfo: any = {};
  vehicleInfo: any = {};
  quote: any = null;
  quote_month: any = null;
  quoteReference: any = null;

  carModels: string[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.fetchCarModels();
  }

  //Fetch all the Car Models
  fetchCarModels() {
    this.http.get('https://storage.googleapis.com/connex-th/insurance_assignment/car_model.json')
      .subscribe((data: any) => {
        this.carModels = data.data.car_Model_Lists.results.map((car: any) => car.Model);
      });
  }

  submitForm(form: NgForm) {

    // Check if the form is valid
    if (form.invalid) {
      return;
    }

    // Validating the fields
    if (this.driverInfo.age < 0) {
      form.controls['age'].setErrors({ 'negativeAge': true });
    }

    if (this.driverInfo.drivingExperience < 0) {
      form.controls['drivingExperience'].setErrors({ 'negativeExp': true });
    }

    if (this.driverInfo.driverRecord < 0) {
      form.controls['driverRecord'].setErrors({ 'negativeRecord': true });
    }

    if (this.driverInfo.claims < 0) {
      form.controls['claims'].setErrors({ 'negativeClaims': true });
    }

    if (this.driverInfo.carValue < 0) {
      form.controls['carValue'].setErrors({ 'negativecarValue': true });
    }

    if (this.driverInfo.annualMileage < 0) {
      form.controls['annualMileage'].setErrors({ 'negativeMileage': true });
    }

    // Create the request
    const form_data = {
      age: this.driverInfo.age,
      drivingExperience: this.driverInfo.drivingExperience,
      driverRecord: this.driverInfo.driverRecord,
      claims: this.driverInfo.claims,
      carValue: this.driverInfo.carValue,
      annualMileage: this.driverInfo.annualMileage,
      insuranceHistory: this.driverInfo.insuranceHistory
    };

    // Send the request to the backend API
    this.http.post('http://localhost:8080/insurance/quote', form_data)
      .subscribe(
        (response: any) => {
          this.quote = response.premium;
          this.quote_month = this.quote / 12;
          this.quoteReference = response.quoteReference;

        },
        (error: any) => {
          console.log("Data not sent");
          console.error('Error:', error);
        }
      );

  }
}
