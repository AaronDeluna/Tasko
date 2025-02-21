package org.javaacademy.tasko.service;

import org.javaacademy.tasko.dto.project.CreateProjectDto;
import org.javaacademy.tasko.dto.project.CreateProjectDtoRes;
import org.javaacademy.tasko.dto.project.ProjectDto;

import java.util.List;

public interface ProjectService {
    CreateProjectDtoRes create(String email, CreateProjectDto createProjectDto);
    ProjectDto update(String email, ProjectDto projectDto);
    void deleteById(String email, Integer projectId);
    List<ProjectDto> findAllByEmail(String email);
}
