package com.example.vehicle_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vehicle_service.model.Vehicle;
import com.example.vehicle_service.model.VehicleStatus;
import com.example.vehicle_service.repository.VehicleRepository;

@Service

public class VehicleService {

	@Autowired
    private VehicleRepository vehicleRepository;

//    public List<Vehicle> getAllVehicles() {
//        return vehicleRepository.findAll();
//        
//        
//    }
    
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> list = vehicleRepository.findAll();
        System.out.println("Fetched vehicles: " + list.size());
        return list;
    }


    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        Vehicle existing = getVehicleById(id);

        if (updatedVehicle.getVehicleNumber() != null) {
            existing.setVehicleNumber(updatedVehicle.getVehicleNumber());
        }
        if (updatedVehicle.getType() != null) {
            existing.setType(updatedVehicle.getType());
        }
        if (updatedVehicle.getCapacity() != null) {
            existing.setCapacity(updatedVehicle.getCapacity());
        }
        if (updatedVehicle.getStatus() != null) {
            existing.setStatus(updatedVehicle.getStatus());
        }

        return vehicleRepository.save(existing);
    }


    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    public List<Vehicle> getAvailableVehicles() {
        return vehicleRepository.findByStatus(VehicleStatus.AVAILABLE);
    }
}