package com.ForoHub.DTO;
import com.ForoHub.Models.Course;
import com.ForoHub.Models.Entrance;

import java.time.LocalDateTime;

public record ListEntranceDTO(
        Long id,
        String title,
        String message,
        String author,
        String replies,
        Boolean published,
        Course course) {

    public ListEntranceDTO(Entrance entrance) {
        this(
                entrance.getId(),
                entrance.getTitle(),
                entrance.getMessage(),
                entrance.getAuthor(),
                entrance.getReplies(),
                entrance.getPublished(),
                entrance.getCourse()
                );
    }

}