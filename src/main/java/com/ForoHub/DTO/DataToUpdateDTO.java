package com.ForoHub.DTO;

import jakarta.validation.constraints.NotNull;

public record DataToUpdateDTO(
        @NotNull
        Long id,
        String message,
        String title,
        Boolean published,
        CourseDTO courseDTO) {
}
