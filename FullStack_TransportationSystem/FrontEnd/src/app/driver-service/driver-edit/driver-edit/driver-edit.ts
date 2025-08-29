import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AvailabilityStatus, Driver } from '../../../models/Driver';
import { DriverService } from '../../../../services/driver';

@Component({
  selector: 'app-driver-edit',
  standalone: true,
  imports: [FormsModule, CommonModule,RouterLink],
  templateUrl: './driver-edit.html',
  styleUrls: ['./driver-edit.css']
})
export class DriverEdit implements OnInit {
  driverId!: number;
  driver: Driver = {
    name: '',
    licenseNumber: '',
    phoneNumber: '',
    email: '',
    availabilityStatus: AvailabilityStatus.AVAILABLE
  };

  constructor(
    private driverService: DriverService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.driverId = Number(this.activatedRoute.snapshot.paramMap.get('id'));
    this.loadDriver();
  }

  loadDriver() {
    this.driverService.getDriverById(this.driverId).subscribe({
      next: (data) => this.driver = data,
      error: (err) => alert('Error loading driver: ' + err.message)
    });
  }

  onSubmit() {
    this.driverService.updateDriver(this.driverId, this.driver).subscribe({
      next: () => {
        alert('Driver updated successfully');
        this.router.navigate(['/driver']);
      },
      error: (err) => alert('Error updating driver: ' + err.message)
    });
  }
}
