package com.jheisonnovak.clean_architecture_spring.modules.task.application.usecases;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jheisonnovak.clean_architecture_spring.modules.task.application.dtos.ListTaskDto;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.entities.Task;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.repositories.TaskRepository;

@Service
public class FindAllTasksUseCase {
    private final TaskRepository taskRepository;

    public FindAllTasksUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<ListTaskDto> execute() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(task -> new ListTaskDto(task.getId(), task.getTitle(), task.getDescription(), task.getStatus().name()))
                .toList();
    }
}
