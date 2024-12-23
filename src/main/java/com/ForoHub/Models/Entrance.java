package com.ForoHub.Models;

import com.ForoHub.DTO.DataToUpdateDTO;
import com.ForoHub.DTO.EntranceDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    @Column(name = "creation_date", updatable = false, insertable = false, nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime creationDate;
    private String author;
    private String replies;
    private Boolean published;
    @Embedded
    private Course course;

    public Entrance(){}

    public Entrance(EntranceDTO entranceDTO) {
        this.published = true;
        this.title = entranceDTO.title();
        this.message = entranceDTO.message();
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









    public Boolean getPublished() {
        return published;
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

    public String getAuthor() {
        return author;
    }

    public String getReplies() {
        return replies;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setReplies(String replies) {
        this.replies = replies;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}













