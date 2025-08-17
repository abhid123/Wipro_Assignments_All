package com.smartcity.route.repo;

import com.smartcity.route.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findByMode(String mode);
    List<Route> findByActive(Boolean active);
}
