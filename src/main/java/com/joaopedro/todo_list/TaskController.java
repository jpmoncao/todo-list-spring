package com.joaopedro.todo_list;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return this.repository.findAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return this.repository.save(task);
    }

    @PutMapping("/{id}")
    public Task alterTask(@RequestBody Task task, @PathVariable("id") Long id) {
        Task oldTask = this.repository.findById(id).orElseThrow(() -> new Error("Task not found!"));

        oldTask.setDescription(task.getDescription());
        oldTask.setCompleted(task.isCompleted());

        return this.repository.save(oldTask);
    }
}
