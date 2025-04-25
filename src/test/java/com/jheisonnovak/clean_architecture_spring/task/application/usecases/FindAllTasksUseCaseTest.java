package com.jheisonnovak.clean_architecture_spring.task.application.usecases;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jheisonnovak.clean_architecture_spring.modules.task.application.mappers.TaskMapper;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.usecases.FindAllTasksUseCase;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.entities.Task;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.repositories.TaskRepository;

@ExtendWith(MockitoExtension.class)
public class FindAllTasksUseCaseTest {
    @InjectMocks
    private FindAllTasksUseCase findAllTasksUseCase;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskMapper taskMapper;

    @Test
    void shouldFindAllTasks() {
        // Given
        List<Task> tasks = Arrays.asList(
            new Task("Task 1", "Description 1"),
            new Task("Task 2", "Description 2")
        );
        
        // Setup repository mock
        when(taskRepository.findAll()).thenReturn(tasks);
        
        // When
        findAllTasksUseCase.execute();

        // Then
        verify(taskRepository).findAll();
    }
}
