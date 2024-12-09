package com.ForoHub.DTO;

import com.ForoHub.Models.Course;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EntranceDTO(
        @NotBlank
        String id,
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotBlank
        String creationDate,
        @NotBlank
        String status,
        @NotBlank
        String author,
        @NotNull
        @Valid
        CourseDTO courseDTO,
        @NotBlank
        String replies) {
}
