package com.example.taskmanagerapi.service;

import com.example.taskmanagerapi.dto.TaskUpdateDTO;
import com.example.taskmanagerapi.exception.TaskNotFoundException;
import com.example.taskmanagerapi.model.Task;
import com.example.taskmanagerapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> listAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("Tarefa não encontrada com o ID: " + id);
        }
        taskRepository.deleteById(id);
    }

    public Task updateTask(Long id, TaskUpdateDTO updatedTaskDTO) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isEmpty()) {
            throw new TaskNotFoundException("Tarefa não encontrada com o ID: " + id);
        }

        Task task = existingTask.get();

        if (updatedTaskDTO.getTitle() != null) {
            task.setTitle(updatedTaskDTO.getTitle());
        } else {
            task.setTitle(existingTask.get().getTitle());
        }

        if (updatedTaskDTO.getDescription() != null) {
            task.setDescription(updatedTaskDTO.getDescription());
        }

        if (updatedTaskDTO.getStatus() != null) {
            task.setStatus(updatedTaskDTO.getStatus());
        }

        return taskRepository.save(task);
    }
}
