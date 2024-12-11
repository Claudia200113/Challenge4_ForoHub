package com.ForoHub.Models;

import com.ForoHub.DTO.CourseDTO;
import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Course {
    private String name;
    private String category;


    public Course(CourseDTO courseDTO) {
        this.name = courseDTO.name();
        this.category = courseDTO.category();
    }

    public Course(){}

    public Course updateData(CourseDTO courseDTO) {
        this.name = courseDTO.name();
        this.category = courseDTO.category();
        return this;
    }







    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}