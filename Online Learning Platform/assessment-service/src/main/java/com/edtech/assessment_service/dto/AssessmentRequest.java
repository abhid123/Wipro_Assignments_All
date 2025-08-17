package com.edtech.assessment_service.dto;

import jakarta.validation.constraints.NotBlank;

public class AssessmentRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String type;

    private String description;
    private int totalMarks;

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getTotalMarks() { return totalMarks; }
    public void setTotalMarks(int totalMarks) { this.totalMarks = totalMarks; }
}
