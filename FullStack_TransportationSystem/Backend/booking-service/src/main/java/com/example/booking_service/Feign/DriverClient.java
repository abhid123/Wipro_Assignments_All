package com.example.booking_service.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.booking_service.dto.DriverDTO;

@FeignClient(name="driver-service", url="http://localhost:3333")
public interface DriverClient {
    @GetMapping("/drivers/{id}")
    DriverDTO getDriverById(@PathVariable Long id);
}
