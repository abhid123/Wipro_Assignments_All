package com.example.driver_service.service;


import org.springframework.stereotype.Service;

import com.example.driver_service.model.Driver;
import com.example.driver_service.repository.DriverRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver addDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Optional<Driver> getDriverById(Long id) {
        return driverRepository.findById(id);
    }

    public Driver updateDriver(Long id, Driver driverDetails) {
        return driverRepository.findById(id).map(driver -> {
            driver.setName(driverDetails.getName());
            driver.setLicenseNumber(driverDetails.getLicenseNumber());
            driver.setPhoneNumber(driverDetails.getPhoneNumber());
            driver.setEmail(driverDetails.getEmail());
            driver.setAvailabilityStatus(driverDetails.getAvailabilityStatus());
            driver.setVehicleId(driverDetails.getVehicleId());
            return driverRepository.save(driver);
        }).orElseThrow(() -> new RuntimeException("Driver not found with id " + id));
    }

    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }
}

