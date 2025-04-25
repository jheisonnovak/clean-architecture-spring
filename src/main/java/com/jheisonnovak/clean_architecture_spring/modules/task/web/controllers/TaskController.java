package com.jheisonnovak.clean_architecture_spring.modules.task.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jheisonnovak.clean_architecture_spring.modules.task.application.dtos.CreateTaskDto;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.dtos.UpdateTaskDto;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.usecases.CreateTaskUseCase;
import com.jheisonnovak.clean_architecture_spring.modules.task.application.usecases.UpdateTaskUseCase;
import com.jheisonnovak.clean_architecture_spring.shared.dtos.ResponseDto;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/task")
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    
    public TaskController(CreateTaskUseCase createTaskUseCase, UpdateTaskUseCase updateTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createTask(@Valid @RequestBody CreateTaskDto dto) {
        createTaskUseCase.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("Task successfully created"));
    }

    @PatchMapping("/update/{taskId}")
    public ResponseEntity<ResponseDto> updateTask(@PathVariable Long taskId, @Valid @RequestBody UpdateTaskDto dto) {
        updateTaskUseCase.execute(taskId, dto);
        return ResponseEntity.ok(new ResponseDto("Task successfully updated"));
    }
    
}
