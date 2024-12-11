package com.ForoHub.DTO;

import com.ForoHub.Models.Course;

public record ResponseEntranceDTO(
         Long id,
         String title,
         String message,
         String creationDate,
         String status,
         String author,
         String replies,
         Course course) {
}
