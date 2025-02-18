package org.javaacademy.tasko.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.tasko.dto.project.CreateProjectDto;
import org.javaacademy.tasko.dto.project.CreateProjectDtoRes;
import org.javaacademy.tasko.dto.project.ProjectDto;
import org.javaacademy.tasko.dto.user.UserDto;
import org.javaacademy.tasko.service.ProjectService;
import org.javaacademy.tasko.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<CreateProjectDtoRes> create(@RequestHeader("Authorization") String token,
                                                      @RequestBody CreateProjectDto createProjectDto) {
        UserDto userDto = JwtUtil.parseToken(token);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projectService.create(userDto.getId(), createProjectDto));
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAll(@RequestHeader("Authorization") String token) {
        UserDto userDto = JwtUtil.parseToken(token);
        return ResponseEntity.ok().body(projectService.findAll(userDto.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@RequestHeader("Authorization") String token,
                                                 @PathVariable Integer id) {
        UserDto userDto = JwtUtil.parseToken(token);
        projectService.deleteById(id, userDto.getId());
        return ResponseEntity.ok().build();
    }
}