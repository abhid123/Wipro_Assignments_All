package com.smartcity.notification.controller;

import com.smartcity.notification.model.Subscription;
import com.smartcity.notification.repo.SubscriptionRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class NotificationController {

    private final SubscriptionRepository repo;

    public NotificationController(SubscriptionRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/subscriptions")
    public Subscription create(@RequestBody Subscription s){ return repo.save(s); }

    @GetMapping("/subscriptions/mine")
    public List<Subscription> mine(@RequestParam Long userId){ return repo.findByUserId(userId); }

    @DeleteMapping("/subscriptions/{id}")
    public void delete(@PathVariable Long id){ repo.deleteById(id); }
}
