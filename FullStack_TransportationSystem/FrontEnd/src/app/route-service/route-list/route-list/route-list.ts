import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { RouteService } from '../../../../services/route';
import { RouteModel } from '../../../models/Route';   

@Component({
  selector: 'app-route-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './route-list.html',
  styleUrls: ['./route-list.css']
})
export class RouteList implements OnInit {
  routes: RouteModel[] = [];
  errorMessage = '';
  isLoading = true;

  constructor(
    private routeService: RouteService,
    private cdr: ChangeDetectorRef,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadRoutes();
  }

  loadRoutes(): void {
    console.log('Loading Routes...');
    this.routeService.getAllRoutes().subscribe({
      next: (data) => {
        console.log('API Response:', data);
        this.routes = Array.isArray(data) ? data : [];
        this.isLoading = false;
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error('Error fetching routes:', err);
        this.errorMessage = 'Failed to load routes';
        this.isLoading = false;
      }
    });
  }

  deleteRoute(id: number | undefined): void {
    if (!id) return;

    const confirmed = window.confirm('Are you sure you want to delete this route?');
    if (!confirmed) return;

    this.routeService.deleteRoute(id).subscribe({
      next: () => {
        console.log('Route deleted');
        this.routes = this.routes.filter(r => r.routeId !== id);
        alert('Route deleted successfully');
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error('Error deleting route', err);
        alert('Error deleting route');
      }
    });
  }

  editRoute(id: number | undefined): void {
    this.router.navigate(['/route-edit', id]);
  }
}
