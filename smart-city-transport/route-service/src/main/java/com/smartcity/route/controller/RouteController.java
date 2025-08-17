package com.smartcity.route.controller;

import com.smartcity.route.model.Route;
import com.smartcity.route.repo.RouteRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class RouteController {

    private final RouteRepository repo;

    public RouteController(RouteRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/routes")
    public List<Route> routes(@RequestParam(required = false) String mode,
                              @RequestParam(required = false) Boolean active) {
        if (mode != null) return repo.findByMode(mode.toUpperCase());
        if (active != null) return repo.findByActive(active);
        return repo.findAll();
    }

    @GetMapping("/routes/{id}")
    public Route get(@PathVariable Long id) { return repo.findById(id).orElse(null); }
}
