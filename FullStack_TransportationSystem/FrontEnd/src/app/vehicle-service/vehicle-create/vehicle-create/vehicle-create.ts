import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { Vehicle } from '../../../models/Vehicle';
import { VehicleService } from '../../../../services/vehicle';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-vehicle-create',
  imports:[CommonModule, FormsModule, RouterLink],
  templateUrl: './vehicle-create.html',
  styleUrls: ['./vehicle-create.css']
})
export class VehicleCreate {
  vehicle: Vehicle = {
    vehicleNumber: '',
    type: 'CAR',
    capacity: 0,
    status: 'AVAILABLE'
  };

  constructor(private vehicleService: VehicleService, private router: Router) {}

  onSubmit() {
    this.vehicleService.addVehicle(this.vehicle).subscribe({
      next: () => {
        alert('Vehicle added successfully');
        this.router.navigate(['/vehicle']);
      },
      error: () => alert('Error adding vehicle')
    });
  }
}
