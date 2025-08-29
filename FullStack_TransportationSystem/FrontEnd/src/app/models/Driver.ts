export enum AvailabilityStatus {
  AVAILABLE = 'AVAILABLE',
  ON_TRIP = 'ON_TRIP',
  OFF_DUTY = 'OFF_DUTY'
}

export interface Driver {
  driverId?: number;
  name: string;
  licenseNumber: string;
  phoneNumber: string;
  email: string;
  availabilityStatus: AvailabilityStatus;
  vehicleId?: number;
  createdAt?: string;
  updatedAt?: string;
}
