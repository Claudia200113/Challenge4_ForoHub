package com.ForoHub.DTO;

import jakarta.validation.Valid;
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
        String author,

        String replies,
        @NotBlank
        Boolean published,
        @NotNull
        @Valid
        CourseDTO courseDTO
       ) {
}
