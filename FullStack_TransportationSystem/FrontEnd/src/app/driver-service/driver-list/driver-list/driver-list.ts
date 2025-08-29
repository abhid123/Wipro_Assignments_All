import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { Driver } from '../../../models/Driver';
import { DriverService } from '../../../../services/driver';

@Component({
  selector: 'app-driver-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './driver-list.html',
  styleUrls: ['./driver-list.css']
})
export class DriverList implements OnInit {
  drivers: Driver[] = [];
  errorMessage = '';
  isLoading = true;

  constructor(
    private driverService: DriverService,
    private cdr: ChangeDetectorRef,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadDrivers();
  }

  loadDrivers(): void {
    console.log("Loading drivers...");
    this.driverService.getAllDrivers().subscribe({
      next: (data) => {
        console.log("API Response: ", data);
        this.drivers = Array.isArray(data) ? data : [];
        this.isLoading = false;
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error("Error fetching drivers:", err);
        this.errorMessage = 'Failed to load drivers';
        this.isLoading = false;
      }
    });
  }

  deleteDriver(id: number | undefined): void {
    if (!id) return;

    const confirmed = window.confirm('Are you sure you want to delete this driver?');
    if (!confirmed) return;

    this.driverService.deleteDriver(id).subscribe({
      next: () => {
        console.log('Driver deleted');
        this.drivers = this.drivers.filter(d => d.driverId !== id);
        alert('Driver deleted successfully');
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error('Error deleting driver', err);
        alert('Error deleting driver');
      }
    });
  }

  editDriver(id: number | undefined): void {
    if (id) {
      this.router.navigate(['/driver-edit', id]);
    }
  }
}
