package com.jheisonnovak.clean_architecture_spring.modules.task.application.usecases;

import org.springframework.stereotype.Service;

import com.jheisonnovak.clean_architecture_spring.modules.task.application.dtos.UpdateTaskDto;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.mappers.TaskMapper;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.repositories.TaskRepository;
import com.jheisonnovak.clean_architecture_spring.shared.exception.NotFoundException;

@Service
public class UpdateTaskUseCase {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    
    UpdateTaskUseCase(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public void execute(Long id, UpdateTaskDto updateTaskDto) {
        var task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Task not found"));
        task.validateUpdatable();
        taskMapper.updateEntity(updateTaskDto, task);
        taskRepository.save(task);
    }
}
