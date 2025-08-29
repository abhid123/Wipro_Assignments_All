import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RouteModel } from '../app/models/Route';   

@Injectable({
  providedIn: 'root'
})
export class RouteService {
  private apiUrl = 'http://localhost:2222/routes';

  constructor(private http: HttpClient) {}

  getAllRoutes(): Observable<RouteModel[]> {
    return this.http.get<RouteModel[]>(this.apiUrl);
  }

  getRouteById(id: number): Observable<RouteModel> {
    return this.http.get<RouteModel>(`${this.apiUrl}/${id}`);
  }

  addRoute(route: RouteModel): Observable<RouteModel> {
    return this.http.post<RouteModel>(this.apiUrl, route);
  }

  updateRoute(id: number, route: RouteModel): Observable<RouteModel> {
    return this.http.put<RouteModel>(`${this.apiUrl}/${id}`, route);
  }

  deleteRoute(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`, { responseType: 'text' });
  }
}
