import { Routes } from '@angular/router';
import { Menu } from './menu/menu/menu';
import { VehicleList } from './vehicle-service/vehicle-list/vehicle-list/vehicle-list';
import { VehicleCreate } from './vehicle-service/vehicle-create/vehicle-create/vehicle-create';
import { VehicleEdit } from './vehicle-service/vehicle-edit/vehicle-edit/vehicle-edit';
import { RouteList } from './route-service/route-list/route-list/route-list';
import { RouteCreate } from './route-service/route-create/route-create/route-create';
import { RouteEdit } from './route-service/route-edit/route-edit/route-edit';
import { DriverList } from './driver-service/driver-list/driver-list/driver-list';
import { DriverCreate } from './driver-service/driver-create/driver-create/driver-create';
import { DriverEdit } from './driver-service/driver-edit/driver-edit/driver-edit';
import { Booking } from './booking-service/booking/booking';

export const routes: Routes = [
    { path: '', component: Menu },

    { path: 'vehicle', component: VehicleList },
    { path: 'vehicle-create', component: VehicleCreate },
    { path: 'vehicle-edit/:id', component: VehicleEdit },

    { path: 'routes', component: RouteList },
    { path: 'route-create', component: RouteCreate },
    { path: 'route-edit/:id', component: RouteEdit },

    { path: 'driver', component: DriverList },
    { path: 'driver-create', component: DriverCreate },
    { path: 'driver-edit/:id', component: DriverEdit },

    { path: 'booking', component: Booking }

];
