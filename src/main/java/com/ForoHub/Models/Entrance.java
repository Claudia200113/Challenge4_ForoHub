package com.ForoHub.Models;

import com.ForoHub.DTO.DataToUpdateDTO;
import com.ForoHub.DTO.EntranceDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="entrance")
@Entity(name="Entrance")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Entrance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String message;
    private String creationDate;
    private String status;
    private String author;
    private String replies;
    private Boolean published;
    @Embedded
    private Course course;

    public Entrance(EntranceDTO entranceDTO) {
        this.published = true;
        this.title = entranceDTO.title();
        this.message = entranceDTO.message();
        this.creationDate = entranceDTO.creationDate();
        this.status = entranceDTO.status();
        this.author = entranceDTO.author();
        this.replies = entranceDTO.replies();
        this.course = new Course(entranceDTO.courseDTO());
    }

    public void UpdateData(DataToUpdateDTO dataToUpdate) {
        if(dataToUpdate.title() != null){
            this.title = dataToUpdate.title();
        }
        if(dataToUpdate.message() != null){
            this.message = dataToUpdate.message();
        }
        if(dataToUpdate.courseDTO() != null){
            this.course = course.updateData(dataToUpdate.courseDTO());
        }
    }

    public void UnpublishEntrance() {
        this.published = false;
    }









    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getStatus() {
        return status;
    }

    public String getAuthor() {
        return author;
    }

    public String getReplies() {
        return replies;
    }

    public Course getCourse() {
        return course;
    }



}













