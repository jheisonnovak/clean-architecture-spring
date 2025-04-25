package com.jheisonnovak.clean_architecture_spring.modules.task.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.jheisonnovak.clean_architecture_spring.modules.task.domain.entities.Task;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.repositories.TaskRepository;

@Repository
public class TaskRepositoryImpl implements TaskRepository{

    private final SpringDataTaskRepository jpaRepository;

    public TaskRepositoryImpl(SpringDataTaskRepository jpaRepository) {
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
        return jpaRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}