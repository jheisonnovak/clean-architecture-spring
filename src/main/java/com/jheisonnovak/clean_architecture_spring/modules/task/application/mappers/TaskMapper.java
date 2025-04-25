package com.jheisonnovak.clean_architecture_spring.modules.task.application.mappers;

import org.springframework.stereotype.Component;

import com.jheisonnovak.clean_architecture_spring.modules.task.application.dtos.CreateTaskDto;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.dtos.UpdateTaskDto;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.entities.Task;

@Component
public class TaskMapper {
    public Task toEntity(CreateTaskDto createTaskDto) {
        return new Task(createTaskDto.getTitle(), createTaskDto.getDescription());
    }

    public Task updateEntity(UpdateTaskDto updateTaskDto, Task task) {
        task.setStatus(updateTaskDto.getStatus());
        return task;
    }
}
