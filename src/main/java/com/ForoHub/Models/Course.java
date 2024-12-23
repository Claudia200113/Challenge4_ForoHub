package com.ForoHub.Models;

import com.ForoHub.DTO.CourseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Course {
    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "course_category", nullable = false)
    private String courseCategory;

    public Course(CourseDTO courseDTO) {
        this.courseName = courseDTO.courseName();
        this.courseCategory = courseDTO.courseCategory();
    }

    public Course(){}

    public Course updateData(CourseDTO courseDTO) {
        this.courseName = courseDTO.courseName();
        this.courseCategory = courseDTO.courseCategory();
        return this;
    }







    public String getCourseName() {
        return courseName;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }
}