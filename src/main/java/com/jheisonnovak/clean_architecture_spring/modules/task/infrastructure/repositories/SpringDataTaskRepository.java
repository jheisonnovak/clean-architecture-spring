package com.jheisonnovak.clean_architecture_spring.modules.task.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jheisonnovak.clean_architecture_spring.modules.task.domain.entities.Task;

public interface SpringDataTaskRepository extends JpaRepository<Task, Long> {
}
