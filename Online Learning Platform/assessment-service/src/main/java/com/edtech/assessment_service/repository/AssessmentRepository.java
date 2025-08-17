package com.edtech.assessment_service.repository;

import com.edtech.assessment_service.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
}
