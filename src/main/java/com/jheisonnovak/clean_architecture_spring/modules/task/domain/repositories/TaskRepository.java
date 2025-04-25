package com.jheisonnovak.clean_architecture_spring.modules.task.domain.repositories;
import java.util.List;
import java.util.Optional;

import com.jheisonnovak.clean_architecture_spring.modules.task.domain.entities.Task;

public interface TaskRepository {
    Task save(Task task);
    Optional<Task> findById(Long id);
    List<Task> findAll();
    void deleteById(Long id);
}
