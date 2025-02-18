package org.javaacademy.tasko.service;

import org.javaacademy.tasko.dto.project.CreateProjectDto;
import org.javaacademy.tasko.dto.project.CreateProjectDtoRes;
import org.javaacademy.tasko.dto.project.ProjectDto;

import java.util.List;

public interface ProjectService {
    CreateProjectDtoRes create(Integer userid, CreateProjectDto createProjectDto);
    List<ProjectDto> findAll(Integer userId);
    ProjectDto findById(Integer userid, Integer id);
    ProjectDto updateById(Integer id);
    void deleteById(Integer userId, Integer id);
}
