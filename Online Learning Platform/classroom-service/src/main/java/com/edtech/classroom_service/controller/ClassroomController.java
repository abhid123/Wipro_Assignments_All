package com.edtech.classroom_service.controller;

import com.edtech.classroom_service.dto.ClassroomRequest;
import com.edtech.classroom_service.entity.Classroom;
import com.edtech.classroom_service.repository.ClassroomRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {

    private final ClassroomRepository repo;

    public ClassroomController(ClassroomRepository repo) {
        this.repo = repo;
    }

    // Create Classroom
    @PostMapping("/create")
    public Map<String, Object> createClassroom(@Valid @RequestBody ClassroomRequest req) {
        Classroom c = new Classroom();
        c.setCourseName(req.getCourseName());
        c.setTeacherName(req.getTeacherName());
        c.setSchedule(req.getSchedule());
        c.setTotalStudents(req.getTotalStudents());

        repo.save(c);

        return Map.of("id", c.getId(), "message", "Classroom created successfully");
    }

    // Get all classrooms
    @GetMapping("/all")
    public List<Classroom> getAllClassrooms() {
        return repo.findAll();
    }

    // Get classroom by ID
    @GetMapping("/{id}")
    public Classroom getClassroom(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Classroom not found"));
    }
}
