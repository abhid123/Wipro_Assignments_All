package com.edtech.classroom_service.repository;

import com.edtech.classroom_service.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
