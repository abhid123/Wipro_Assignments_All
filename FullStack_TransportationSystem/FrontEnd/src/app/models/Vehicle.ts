export interface Vehicle {
  vehicleId?: number;
  vehicleNumber: string;
  type: 'BUS' | 'CAR' | 'VAN' | 'TRUCK';
  capacity: number;
  status: 'AVAILABLE' | 'ON_TRIP' | 'MAINTENANCE';
  createdAt?: string;
  updatedAt?: string;
}
