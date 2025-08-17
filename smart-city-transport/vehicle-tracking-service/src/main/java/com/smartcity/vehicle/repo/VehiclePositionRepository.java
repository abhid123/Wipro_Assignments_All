package com.smartcity.vehicle.repo;

import com.smartcity.vehicle.model.VehiclePosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiclePositionRepository extends JpaRepository<VehiclePosition, Long> {
    VehiclePosition findTop1ByVehicleIdOrderByTsDesc(Long vehicleId);
}
