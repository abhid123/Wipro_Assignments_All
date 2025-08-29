package com.example.route_service.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.route_service.model.Route;
import com.example.route_service.repository.RouteRepository;

@Service
public class RouteService {

	@Autowired
    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

//    public Route addRoute(Route route) {
//        return routeRepository.save(route);
//    }
    
    public Route addRoute(Route route) {
        route.setRouteId(null); 
        return routeRepository.save(route);
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Optional<Route> getRouteById(Long id) {
        return routeRepository.findById(id);
    }

    public Route updateRoute(Long id, Route routeDetails) {
        return routeRepository.findById(id).map(route -> {
            route.setSource(routeDetails.getSource());
            route.setDestination(routeDetails.getDestination());
            route.setDistanceKm(routeDetails.getDistanceKm());
            route.setEstimatedDurationMin(routeDetails.getEstimatedDurationMin());
            route.setStops(routeDetails.getStops());
            return routeRepository.save(route);
        }).orElseThrow(() -> new RuntimeException("Route not found with id " + id));
    }

    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }
}
