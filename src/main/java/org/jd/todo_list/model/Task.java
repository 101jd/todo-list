package org.jd.todo_list.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Id
            @Column(name = "id")
    Integer id;
    @Column(name = "description")
    String description;
    @Column(name = "date")
    LocalDate date = LocalDate.now();
    @Column(name = "deadline")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date deadline;
    @Column(name = "priority")
    Priority priority;
    @Column(name = "status")
    Status status;

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public Date getDeadline() {
        return deadline;
    }

    public int getPriority() {
        return priority.get();
    }

    public int getStatus() {
        return status.get();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setPriority(int priority) {
        this.priority = Priority.getPriorityByValue(priority);
    }

    public void setStatus(int status) {
        this.status = Status.getStatusByValue(status);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", deadline=" + deadline +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }
}
