package com.smartcity.vehicle.controller;

import com.smartcity.vehicle.model.VehiclePosition;
import com.smartcity.vehicle.repo.VehiclePositionRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class VehicleController {

    private final VehiclePositionRepository repo;

    public VehicleController(VehiclePositionRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/telemetry")
    public String ingest(@RequestBody VehiclePosition pos){
        repo.save(pos);
        return "OK";
    }

    @GetMapping("/vehicles/{id}/position")
    public VehiclePosition current(@PathVariable Long id){
        return repo.findTop1ByVehicleIdOrderByTsDesc(id);
    }
}
