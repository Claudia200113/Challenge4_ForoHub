package com.ForoHub.DTO;
import com.ForoHub.Models.Entrance;

public record ListEntranceDTO(
        Long id,
        String title,
        String message,
        String creationDate,
        String author,
        String course,
        String replies) {

    public ListEntranceDTO(Entrance entrance) {
        this(
                entrance.getId(),
                entrance.getTitle(),
                entrance.getMessage(),
                entrance.getCreationDate(),
                entrance.getAuthor(),
                entrance.getCourse().toString(),
                entrance.getReplies()
        );
    }

}