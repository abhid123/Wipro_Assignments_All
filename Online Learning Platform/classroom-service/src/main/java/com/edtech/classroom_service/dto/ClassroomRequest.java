package com.edtech.classroom_service.dto;

import jakarta.validation.constraints.NotBlank;

public class ClassroomRequest {

    @NotBlank
    private String courseName;

    @NotBlank
    private String teacherName;

    private String schedule;
    private int totalStudents;

    // Getters and Setters
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getTeacherName() { return teacherName; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }

    public String getSchedule() { return schedule; }
    public void setSchedule(String schedule) { this.schedule = schedule; }

    public int getTotalStudents() { return totalStudents; }
    public void setTotalStudents(int totalStudents) { this.totalStudents = totalStudents; }
}
