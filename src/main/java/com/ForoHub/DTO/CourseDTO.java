package com.ForoHub.DTO;

import jakarta.validation.constraints.NotBlank;

public record CourseDTO(
        @NotBlank
        String id,
        @NotBlank
        String name,
        @NotBlank
        String category) {
}
