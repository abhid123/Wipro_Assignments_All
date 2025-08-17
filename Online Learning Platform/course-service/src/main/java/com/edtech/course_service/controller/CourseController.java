package com.edtech.course_service.controller;

import com.edtech.course_service.dto.CourseRequest;
import com.edtech.course_service.entity.Course;
import com.edtech.course_service.repository.CourseRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository repo;

    public CourseController(CourseRepository repo) {
        this.repo = repo;
    }

    // Create Course
    @PostMapping("/create")
    public Map<String, Object> createCourse(@Valid @RequestBody CourseRequest req) {
        Course course = new Course();
        course.setTitle(req.getTitle());
        course.setDescription(req.getDescription());
        course.setSyllabus(req.getSyllabus());
        repo.save(course);
        return Map.of("id", course.getId(), "message", "Course created successfully");
    }

    // Get All Courses
    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    // Get Course by ID
    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
    }
}
