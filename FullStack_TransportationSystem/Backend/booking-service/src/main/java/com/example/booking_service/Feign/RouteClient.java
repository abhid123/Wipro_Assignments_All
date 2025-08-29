package com.example.booking_service.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.booking_service.dto.RouteDTO;

@FeignClient(name="route-service", url="http://localhost:2222")
public interface RouteClient {
    @GetMapping("/routes/{id}")
    RouteDTO getRouteById(@PathVariable Long id);
}
