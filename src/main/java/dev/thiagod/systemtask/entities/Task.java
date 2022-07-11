package dev.thiagod.systemtask.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.thiagod.systemtask.entities.enums.TaskStatus;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_task")
public class Task implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant createdOnMoment;
    private String title;
    private TaskStatus taskStatus;
    private String imageUrl;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant modifiedOnMoment;

    public Task(){

    }

    public Task(Long id, Instant createdOnMoment, String title, TaskStatus taskStatus,String imageUrl , Instant modifiedOnMoment) {
        this.id = id;
        this.createdOnMoment = createdOnMoment;
        this.title = title;
        this.taskStatus = taskStatus;
        this.imageUrl = imageUrl;
        this.modifiedOnMoment = modifiedOnMoment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreatedOnMoment() {
        return createdOnMoment;
    }

    public void setCreatedOnMoment(Instant createdOnMoment) {
        this.createdOnMoment = createdOnMoment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Instant getModifiedOnMoment() {
        return modifiedOnMoment;
    }

    public void setModifiedOnMoment(Instant modifiedOnMoment) {
        this.modifiedOnMoment = modifiedOnMoment;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
