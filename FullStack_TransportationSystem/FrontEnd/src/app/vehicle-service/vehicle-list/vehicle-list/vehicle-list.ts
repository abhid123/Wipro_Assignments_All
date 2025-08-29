import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { Vehicle } from '../../../models/Vehicle';
import { VehicleService } from '../../../../services/vehicle';

@Component({
  selector: 'app-vehicle-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './vehicle-list.html',
  styleUrls: ['./vehicle-list.css']
})
export class VehicleList implements OnInit {
  vehicles: Vehicle[] = [];
  errorMessage = '';
  isLoading = true;

  constructor(
    private vehicleService: VehicleService,
    private cdr: ChangeDetectorRef,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadVehicles();
  }

  loadVehicles(): void {
    console.log("Loading Vehicles...");
    this.vehicleService.getAllVehicles().subscribe({
      next: (data) => {
        console.log("API Response: ", data);
        this.vehicles = Array.isArray(data) ? data : [];
        this.isLoading = false;
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error("Error fetching vehicles:", err);
        this.errorMessage = 'Failed to load vehicles';
        this.isLoading = false;
      }
    });
  }

  deleteVehicle(id: number | undefined): void {
    if (!id) return;

    const confirmed = window.confirm('Are you sure you want to delete this vehicle?');
    if (!confirmed) return;

    this.vehicleService.deleteVehicle(id).subscribe({
      next: () => {
        console.log('Vehicle deleted');
        this.vehicles = this.vehicles.filter(v => v.vehicleId !== id);
        alert('Vehicle deleted successfully');
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error('Error deleting vehicle', err);
        alert('Error deleting vehicle');
      }
    });
  }

  editVehicle(id: number | undefined): void {
    this.router.navigate(['/vehicle-edit', id]);
  }
}
