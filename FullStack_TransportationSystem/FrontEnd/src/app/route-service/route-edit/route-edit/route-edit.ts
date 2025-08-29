import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';  
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouteService } from '../../../../services/route';
import { RouteModel } from '../../../models/Route';   

@Component({
  selector: 'app-route-edit',
  standalone: true,
  imports: [FormsModule, CommonModule, RouterLink],
  templateUrl: './route-edit.html',
  styleUrls: ['./route-edit.css']
})
export class RouteEdit implements OnInit {
  routeId!: number;
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
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.routeId = Number(this.activatedRoute.snapshot.paramMap.get('id'));
    this.loadRoute();
  }

  loadRoute(): void {
    this.routeService.getRouteById(this.routeId).subscribe({
      next: (data) => {
        this.route = data;
        this.stopsInput = data.stops?.join(', ') || '';
      },
      error: (err) => alert('Error loading route: ' + err.message)
    });
  }

  onSubmit(): void {
    this.route.stops = this.stopsInput
      .split(',')
      .map(s => s.trim())
      .filter(s => s.length > 0);  

    this.routeService.updateRoute(this.routeId, this.route).subscribe({
      next: () => {
        alert('Route updated successfully');
        this.router.navigate(['/routes']);  
      },
      error: (err) => alert('Error updating route: ' + err.message)
    });
  }
}
