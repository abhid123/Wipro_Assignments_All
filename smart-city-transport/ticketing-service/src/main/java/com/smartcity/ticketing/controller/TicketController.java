package com.smartcity.ticketing.controller;

import com.smartcity.ticketing.model.Ticket;
import com.smartcity.ticketing.repo.TicketRepository;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketRepository repo;

    public TicketController(TicketRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/purchase")
    public Ticket purchase(@RequestBody Ticket t){
        t.setIssuedAt(Instant.now());
        t.setStatus("purchased");
        return repo.save(t);
    }

    @GetMapping("/user/{userId}")
    public List<Ticket> byUser(@PathVariable String userId){
        return repo.findByUserId(userId);
    }
}
