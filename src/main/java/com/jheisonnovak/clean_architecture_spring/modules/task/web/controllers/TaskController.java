package com.jheisonnovak.clean_architecture_spring.modules.task.web.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jheisonnovak.clean_architecture_spring.modules.task.application.dtos.CreateTaskDto;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.dtos.ListTaskDto;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.dtos.UpdateTaskDto;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.usecases.CreateTaskUseCase;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.usecases.DeleteTaskUseCase;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.usecases.FindAllTasksUseCase;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.usecases.FindTaskByIdUseCase;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.usecases.UpdateTaskUseCase;
import com.jheisonnovak.clean_architecture_spring.shared.dtos.ResponseDto;

import jakarta.validation.Valid;


@RestController
@RequestMapping("task")
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final FindAllTasksUseCase findAllTasksUseCase;
    private final FindTaskByIdUseCase findTaskByIdUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    
    public TaskController(
        CreateTaskUseCase createTaskUseCase, 
        UpdateTaskUseCase updateTaskUseCase, 
        FindAllTasksUseCase findAllTasksUseCase, 
        FindTaskByIdUseCase findTaskByIdUseCase, 
        DeleteTaskUseCase deleteTaskUseCase
    ) {
        this.createTaskUseCase = createTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.findAllTasksUseCase = findAllTasksUseCase;
        this.findTaskByIdUseCase = findTaskByIdUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
    }

    @PostMapping()
    public ResponseEntity<ResponseDto> createTask(@Valid @RequestBody CreateTaskDto dto) {
        createTaskUseCase.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("Task successfully created"));
    }

    @PatchMapping("{taskId}")
    public ResponseEntity<ResponseDto> updateTask(@PathVariable Long taskId, @Valid @RequestBody UpdateTaskDto dto) {
        updateTaskUseCase.execute(taskId, dto);
        return ResponseEntity.ok(new ResponseDto("Task successfully updated"));
    }

    @GetMapping()
    public ResponseEntity<List<ListTaskDto>> getAllTasks() {
        List<ListTaskDto> tasks = findAllTasksUseCase.execute();
        return ResponseEntity.ok(tasks);
    }
    
    @GetMapping("{taskId}")
    public ResponseEntity<ListTaskDto> getTaskById(@PathVariable Long taskId) {
        ListTaskDto task = findTaskByIdUseCase.execute(taskId);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("{taskId}")
    public ResponseEntity<ResponseDto> deleteTask(@PathVariable Long taskId) {
        deleteTaskUseCase.execute(taskId);
        return ResponseEntity.ok(new ResponseDto("Task successfully deleted"));
    }

    
}
