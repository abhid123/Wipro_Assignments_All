export interface RouteModel {   
  routeId?: number;
  source: string;
  destination: string;
  distanceKm: number;
  estimatedDurationMin: number;
  stops: string[];
  createdAt?: string;
  updatedAt?: string;
}
