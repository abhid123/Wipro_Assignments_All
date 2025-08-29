import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AvailabilityStatus, Driver } from '../../../models/Driver';
import { DriverService } from '../../../../services/driver';

@Component({
  selector: 'app-driver-create',
  standalone: true,
  imports: [FormsModule, CommonModule, RouterLink],
  templateUrl: './driver-create.html',
  styleUrls: ['./driver-create.css']
})
export class DriverCreate {
  driver: Driver = {
    name: '',
    licenseNumber: '',
    phoneNumber: '',
    email: '',
    availabilityStatus: AvailabilityStatus.AVAILABLE,
    vehicleId: undefined
  };


  AvailabilityStatus = AvailabilityStatus;

  constructor(private driverService: DriverService, private router: Router) {}

  onSubmit() {
    this.driverService.addDriver(this.driver).subscribe({
      next: () => {
        alert('Driver added successfully');
        this.router.navigate(['/driver']);
      },
      error: (err) => {
        console.error('Error adding driver:', err);
        alert('Failed to add driver: ' + (err.error?.message || err.message));
      }
    });
  }
}
