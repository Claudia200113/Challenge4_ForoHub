package com.ForoHub.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public record CourseDTO(
        @NotBlank
        @Column(name = "courseName")
        String courseName,
        @NotBlank
        String courseCategory) {


}
