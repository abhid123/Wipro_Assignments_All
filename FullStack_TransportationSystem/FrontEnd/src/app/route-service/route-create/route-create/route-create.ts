import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';   
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouteService } from '../../../../services/route';
import { RouteModel } from '../../../models/Route';  

@Component({
  selector: 'app-route-create',
  standalone: true,
  imports: [FormsModule, CommonModule,RouterLink],
  templateUrl: './route-create.html',
  styleUrls: ['./route-create.css']
})
export class RouteCreate {
  route: RouteModel = {
    routeId: 0,               
    source: '',
    destination: '',
    distanceKm: 0,
    estimatedDurationMin: 0,
    stops: []
  };
  stopsInput = '';

  constructor(
    private routeService: RouteService,
    private router: Router
  ) {}

  onSubmit(): void {
    this.route.stops = this.stopsInput
      .split(',')
      .map(s => s.trim())
      .filter(s => s.length > 0);   

    this.routeService.addRoute(this.route).subscribe({
      next: () => {
        alert('Route added successfully');
        this.router.navigate(['/routes']);   
      },
      error: (err) => alert('Error adding route: ' + err.message)
    });
  }
}
