package org.javaacademy.tasko.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.tasko.dto.task.CreateTaskDto;
import org.javaacademy.tasko.dto.task.CreateTaskDtoRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {

    @PostMapping
    public ResponseEntity<CreateTaskDtoRes> crate(@RequestBody CreateTaskDto createTaskDto) {

        return ResponseEntity.ok().build();
    }
}
