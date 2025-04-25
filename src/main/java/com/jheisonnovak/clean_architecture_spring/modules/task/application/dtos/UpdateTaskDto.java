package com.jheisonnovak.clean_architecture_spring.modules.task.application.dtos;

import com.jheisonnovak.clean_architecture_spring.modules.task.domain.enums.TaskStatus;

public class UpdateTaskDto {
    
    private TaskStatus status;

    UpdateTaskDto(TaskStatus status) {
        this.status = status;
    }

    public TaskStatus getStatus() {
        return status;
    }
}
