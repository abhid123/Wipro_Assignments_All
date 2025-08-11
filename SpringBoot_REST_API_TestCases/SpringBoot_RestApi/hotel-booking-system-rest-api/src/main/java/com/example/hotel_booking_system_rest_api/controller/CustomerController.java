package com.example.hotel_booking_system_rest_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hotel_booking_system_rest_api.service.CustomerService;
import com.example.hotel_booking_system_rest_api.model.Customer;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody Customer customer) {
        Customer saved = customerService.register(customer);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Customer loginRequest) {
        Customer customer = customerService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (customer == null) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
        return ResponseEntity.ok(customer);
    }
}
