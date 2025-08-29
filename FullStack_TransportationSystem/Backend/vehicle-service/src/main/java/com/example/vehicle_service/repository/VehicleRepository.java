package com.example.vehicle_service.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vehicle_service.model.Vehicle;
import com.example.vehicle_service.model.VehicleStatus;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByStatus(VehicleStatus status);
}
