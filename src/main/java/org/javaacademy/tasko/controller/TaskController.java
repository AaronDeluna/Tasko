package org.javaacademy.tasko.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {

//    @PostMapping
//    public ResponseEntity<?> crate(@RequestHeader("Authorization") String token,
//                                       @RequestBody CreateTaskDto createTaskDto) {
//        taskService.save(token, createTaskDto);
//        return ResponseEntity.ok().build();
//    }
}
