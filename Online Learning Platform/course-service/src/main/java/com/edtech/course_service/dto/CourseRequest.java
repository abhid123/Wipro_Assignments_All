package com.edtech.course_service.dto;

import jakarta.validation.constraints.NotBlank;

public class CourseRequest {

    @NotBlank
    private String title;

    private String description;
    private String syllabus;

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSyllabus() { return syllabus; }
    public void setSyllabus(String syllabus) { this.syllabus = syllabus; }
}
