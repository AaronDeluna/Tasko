package org.javaacademy.tasko.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.tasko.dto.task_column.CreateTaskColumnDto;
import org.javaacademy.tasko.dto.task_column.CreateTaskColumnDtoRes;
import org.javaacademy.tasko.service.TaskColumnService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/column")
@RequiredArgsConstructor
public class TaskColumnController {
    private final TaskColumnService taskColumnService;

    @PostMapping
    public ResponseEntity<CreateTaskColumnDtoRes> create(@RequestBody CreateTaskColumnDto createTaskColumnDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskColumnService.create(createTaskColumnDto));
    }
}
