package com.example.booking_service.Feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.booking_service.dto.VehicleDTO;

@FeignClient(name="vehicle-service", url="http://localhost:1111")
public interface VehicleClient {
    @GetMapping("/vehicles/{id}")
    VehicleDTO getVehicleById(@PathVariable Long id);
}
