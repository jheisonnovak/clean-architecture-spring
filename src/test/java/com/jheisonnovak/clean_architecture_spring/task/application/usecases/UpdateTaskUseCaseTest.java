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

import com.jheisonnovak.clean_architecture_spring.modules.task.application.dtos.UpdateTaskDto;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.mappers.TaskMapper;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.usecases.UpdateTaskUseCase;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.entities.Task;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.enums.TaskStatus;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.repositories.TaskRepository;
import com.jheisonnovak.clean_architecture_spring.shared.exception.NotFoundException;

@ExtendWith(MockitoExtension.class)
public class UpdateTaskUseCaseTest {
    @InjectMocks
    private UpdateTaskUseCase updateTaskUseCase;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskMapper taskMapper;

    @Test
    void shouldUpdateTaskStatus() {
        // Given
        Long taskId = 1L;
        UpdateTaskDto dto = new UpdateTaskDto(TaskStatus.DOING);
        Task existingTask = new Task("Test Task", "Description");
        
        // Setup repository mock
        when(taskRepository.findById(taskId)).thenReturn(java.util.Optional.of(existingTask));
        when(taskRepository.save(existingTask)).thenReturn(existingTask);
        
        // When
        updateTaskUseCase.execute(taskId, dto);

        // Then
        verify(taskRepository).findById(taskId);
        verify(taskRepository).save(existingTask);
    }

    @Test
    void shouldThrowNotFoundExceptionWhenTaskDoesNotExist() {
        // Given
        Long taskId = 1L;
        
        // Setup repository mock
        when(taskRepository.findById(taskId)).thenReturn(Optional.empty());
        
        // When/Then
        assertThrows(NotFoundException.class, () -> {
            UpdateTaskDto dto = new UpdateTaskDto(TaskStatus.DOING);
            updateTaskUseCase.execute(taskId, dto);
        });
    }
}
