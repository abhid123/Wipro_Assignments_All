import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Vehicle } from '../../../models/Vehicle';
import { VehicleService } from '../../../../services/vehicle';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-vehicle-edit',
  imports:[CommonModule, FormsModule, RouterLink],
  templateUrl: './vehicle-edit.html',
  styleUrls: ['./vehicle-edit.css']
})
export class VehicleEdit implements OnInit {
  vehicle: Vehicle = {
    vehicleNumber: '',
    type: 'CAR',
    capacity: 0,
    status: 'AVAILABLE'
  };

  constructor(
    private route: ActivatedRoute,
    private vehicleService: VehicleService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (id) {
      this.vehicleService.getVehicleById(id).subscribe({
        next: (data) => this.vehicle = data,
        error: () => alert('Vehicle not found')
      });
    }
  }

  onSubmit() {
    if (!this.vehicle.vehicleId) return;
    this.vehicleService.updateVehicle(this.vehicle.vehicleId, this.vehicle).subscribe({
      next: () => {
        alert('Vehicle updated successfully');
        this.router.navigate(['/vehicle']);
      },
      error: () => alert('Error updating vehicle')
    });
  }
}
