package com.edtech.notification_service.controller;

import com.edtech.notification_service.dto.NotificationRequest;
import com.edtech.notification_service.entity.Notification;
import com.edtech.notification_service.repository.NotificationRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationRepository repo;

    public NotificationController(NotificationRepository repo) {
        this.repo = repo;
    }

    // Create Notification
    @PostMapping("/create")
    public Map<String, Object> createNotification(@Valid @RequestBody NotificationRequest req) {
        Notification n = new Notification();
        n.setUserId(req.getUserId());
        n.setMessage(req.getMessage());
        n.setType(req.getType());
        n.setStatus("PENDING");
        repo.save(n);
        return Map.of("id", n.getId(), "message", "Notification created successfully");
    }

    // Get All Notifications
    @GetMapping("/all")
    public List<Notification> getAllNotifications() {
        return repo.findAll();
    }

    // Get notifications by User ID
    @GetMapping("/user/{userId}")
    public List<Notification> getByUser(@PathVariable Long userId) {
        return repo.findByUserId(userId);
    }
}
