package com.ForoHub.DTO;

import com.ForoHub.Models.Course;

public record ResponseEntranceDTO(
        Long id,
        String title,
        String message,
        java.time.LocalDateTime creationDate,
        boolean published,
        String author,
        String replies,
        Course course) {
}
