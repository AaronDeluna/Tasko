package org.javaacademy.tasko.controller;


import lombok.RequiredArgsConstructor;
import org.javaacademy.tasko.dto.auth.JwtUserDto;
import org.javaacademy.tasko.dto.project.CreateProjectDto;
import org.javaacademy.tasko.dto.project.CreateProjectDtoRes;
import org.javaacademy.tasko.dto.project.ProjectDto;
import org.javaacademy.tasko.service.JwtTokenService;
import org.javaacademy.tasko.service.ProjectService;
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
    private final JwtTokenService jwtTokenService;

    @PostMapping
    public ResponseEntity<CreateProjectDtoRes> create(@RequestHeader("Authorization") String token,
                                                      @RequestBody CreateProjectDto createProjectDto) {
        JwtUserDto jwtUserDto = jwtTokenService.parseToken(token);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(projectService.create(jwtUserDto.getEmail(), createProjectDto));
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> findAll(@RequestHeader("Authorization") String token) {
        JwtUserDto jwtUserDto = jwtTokenService.parseToken(token);
        return ResponseEntity.ok().body(projectService.findAllByEmail(jwtUserDto.getEmail()));
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<HttpStatus> deleteById(@RequestHeader("Authorization") String token,
                                                 @PathVariable Integer projectId) {
        JwtUserDto jwtUserDto = jwtTokenService.parseToken(token);
        projectService.deleteById(jwtUserDto.getEmail(), projectId);
        return ResponseEntity.ok().build();
    }
}
