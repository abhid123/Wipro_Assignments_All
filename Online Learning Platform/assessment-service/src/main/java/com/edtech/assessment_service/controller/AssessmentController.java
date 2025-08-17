package com.edtech.assessment_service.controller;

import com.edtech.assessment_service.dto.AssessmentRequest;
import com.edtech.assessment_service.entity.Assessment;
import com.edtech.assessment_service.repository.AssessmentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/assessments")
public class AssessmentController {

    private final AssessmentRepository repo;

    public AssessmentController(AssessmentRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/create")
    public Map<String,Object> createAssessment(@Valid @RequestBody AssessmentRequest req) {
        Assessment a = new Assessment();
        a.setTitle(req.getTitle());
        a.setType(req.getType());
        a.setDescription(req.getDescription());
        a.setTotalMarks(req.getTotalMarks());

        repo.save(a);

        return Map.of("id", a.getId(), "message", "Assessment created successfully");
    }

    @GetMapping("/all")
    public List<Assessment> getAllAssessments() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Assessment getAssessment(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Assessment not found"));
    }
}
