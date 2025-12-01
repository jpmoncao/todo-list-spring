package com.joaopedro.todo_list;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_task;
    private String description;
    private boolean completed;

    public Task() {
    }

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    // Getters and Setters
    public Long getId_task() {
        return id_task;
    }

    public void setIdTask(Long id_task) {
        this.id_task = id_task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}