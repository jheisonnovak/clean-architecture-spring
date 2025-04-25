package com.jheisonnovak.clean_architecture_spring.task.application.usecases;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jheisonnovak.clean_architecture_spring.modules.task.application.mappers.TaskMapper;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.usecases.FindTaskByIdUseCase;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.entities.Task;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.repositories.TaskRepository;
import com.jheisonnovak.clean_architecture_spring.shared.exception.NotFoundException;

@ExtendWith(MockitoExtension.class)
public class FindTaskByIdUseCaseTest {
    @InjectMocks
    private FindTaskByIdUseCase findTaskByIdUseCase;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskMapper taskMapper;

    @Test
    void shouldFindTaskById() {
        // Given
        Long taskId = 1L;
        Task task = new Task("Task 1", "Description 1");
        
        // Setup repository mock
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));
        
        // When
        findTaskByIdUseCase.execute(taskId);

        // Then
        verify(taskRepository).findById(taskId);
    }

    @Test
    void shouldThrowNotFoundExceptionWhenTaskDoesNotExist() {
        // Given
        Long taskId = 1L;
        
        // Setup repository mock
        when(taskRepository.findById(taskId)).thenReturn(Optional.empty());
        
        // When/Then
        assertThrows(NotFoundException.class, () -> {
            findTaskByIdUseCase.execute(taskId);
        });
    }
}
