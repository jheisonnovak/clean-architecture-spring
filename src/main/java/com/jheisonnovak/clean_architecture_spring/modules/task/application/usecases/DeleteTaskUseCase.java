package com.jheisonnovak.clean_architecture_spring.modules.task.application.usecases;

import org.springframework.stereotype.Service;

import com.jheisonnovak.clean_architecture_spring.modules.task.domain.repositories.TaskRepository;

@Service
public class DeleteTaskUseCase {
    private final TaskRepository taskRepository;

    public DeleteTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void execute(Long id) {
        taskRepository.deleteById(id);
    }
}
