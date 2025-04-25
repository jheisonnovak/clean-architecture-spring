package com.jheisonnovak.clean_architecture_spring.task.application.usecases;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jheisonnovak.clean_architecture_spring.modules.task.application.dtos.CreateTaskDto;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.mappers.TaskMapper;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.usecases.CreateTaskUseCase;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.entities.Task;
import com.jheisonnovak.clean_architecture_spring.modules.task.domain.repositories.TaskRepository;

@ExtendWith(MockitoExtension.class)
public class CreateTaskUseCaseTest {
    
    @InjectMocks
    private CreateTaskUseCase createTaskUseCase;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskMapper taskMapper;

    @Test
    void shouldCreateTask() {
        // Given
        CreateTaskDto dto = new CreateTaskDto("Test Task", "Test Description");
        Task task = new Task("Test Task", "Test Description");
        
        // Setup mapper mock
        when(taskMapper.toEntity(dto)).thenReturn(task);
        
        // When
        createTaskUseCase.execute(dto);

        // Then
        verify(taskMapper).toEntity(dto);
        verify(taskRepository).save(task);
    }
}
