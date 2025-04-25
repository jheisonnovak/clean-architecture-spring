package com.jheisonnovak.clean_architecture_spring.modules.task.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jheisonnovak.clean_architecture_spring.modules.task.domain.entities.Task;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.repositories.TaskRepository;

@Repository
public class TaskRepositoryJPA implements TaskRepository{

    private final SpringDataTaskRepository jpaRepository;

    public TaskRepositoryJPA(SpringDataTaskRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Task save(Task task) {
        return jpaRepository.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Task> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}