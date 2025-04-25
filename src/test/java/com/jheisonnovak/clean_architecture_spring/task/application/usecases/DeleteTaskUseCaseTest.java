package com.jheisonnovak.clean_architecture_spring.task.application.usecases;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jheisonnovak.clean_architecture_spring.modules.task.application.usecases.DeleteTaskUseCase;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.repositories.TaskRepository;

@ExtendWith(MockitoExtension.class)
public class DeleteTaskUseCaseTest {
    @InjectMocks
    private DeleteTaskUseCase deleteTaskUseCase;

    @Mock
    private TaskRepository taskRepository;

    @Test
    void shouldDeleteTaskById() {
        // Given
        Long taskId = 1L;
        
        // When
        deleteTaskUseCase.execute(taskId);

        // Then
        verify(taskRepository).deleteById(taskId);
    }
}
