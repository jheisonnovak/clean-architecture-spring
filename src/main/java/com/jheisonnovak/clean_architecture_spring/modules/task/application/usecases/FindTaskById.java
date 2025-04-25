package com.jheisonnovak.clean_architecture_spring.modules.task.application.usecases;

import org.springframework.stereotype.Service;

import com.jheisonnovak.clean_architecture_spring.modules.task.application.dtos.ListTaskDto;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.entities.Task;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.repositories.TaskRepository;
import com.jheisonnovak.clean_architecture_spring.shared.exception.NotFoundException;

@Service
public class FindTaskById {
    private final TaskRepository taskRepository;

    public FindTaskById(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public ListTaskDto execute(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Task not found"));
        return new ListTaskDto(task.getId(), task.getTitle(), task.getDescription(), task.getStatus().name());
    }
}
