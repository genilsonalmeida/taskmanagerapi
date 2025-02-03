package com.example.taskmanagerapi.controller;

import com.example.taskmanagerapi.dto.TaskUpdateDTO;
import com.example.taskmanagerapi.exception.TaskNotFoundException;
import com.example.taskmanagerapi.model.Status;
import com.example.taskmanagerapi.model.Task;
import com.example.taskmanagerapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> listAll() {
        return taskService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        Optional<Task> task = taskService.findById(id);
        if (task.isEmpty()) {
            throw new TaskNotFoundException("Tarefa não encontrada com o ID: " + id);
        }
        return ResponseEntity.ok(task.get());
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        if (task.getStatus() == null) {
            task.setStatus(Status.PENDENTE);
        }
        return taskService.save(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskUpdateDTO updatedTaskDTO) {
        Task task = taskService.updateTask(id, updatedTaskDTO);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        Optional<Task> task = taskService.findById(id);
        if (task.isEmpty()) {
            throw new TaskNotFoundException("Tarefa não encontrada com o ID: " + id);
        }

        taskService.delete(id);
        return ResponseEntity.ok("Tarefa deletada com sucesso.");
    }
}
