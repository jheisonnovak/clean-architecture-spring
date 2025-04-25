package com.jheisonnovak.clean_architecture_spring.modules.task.application.usecases;

import org.springframework.stereotype.Service;

import com.jheisonnovak.clean_architecture_spring.modules.task.application.dtos.CreateTaskDto;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.mappers.TaskMapper;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.entities.Task;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.repositories.TaskRepository;

@Service
public class CreateTaskUseCase {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public CreateTaskUseCase(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public Task execute(CreateTaskDto createTaskDto) {
        Task task = taskMapper.toEntity(createTaskDto);
        return taskRepository.save(task);
    }
}
