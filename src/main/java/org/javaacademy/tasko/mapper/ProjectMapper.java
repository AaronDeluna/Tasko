package org.javaacademy.tasko.mapper;

import org.javaacademy.tasko.dto.project.CreateProjectDto;
import org.javaacademy.tasko.dto.project.CreateProjectDtoRes;
import org.javaacademy.tasko.dto.project.ProjectDto;
import org.javaacademy.tasko.entity.Project;
import org.javaacademy.tasko.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ProjectMapper {

    public Project toEntity(CreateProjectDto dto) {
        return new Project(
                dto.getName(),
                dto.getDescription()
        );
    }

    public CreateProjectDtoRes toDtoRes(Project entity) {
        return CreateProjectDtoRes.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }

    public ProjectDto toDto(Project entity) {
        return ProjectDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .createAt(entity.getCreateAt())
                .build();
    }

    public List<ProjectDto> toDtoList(List<Project> projects) {
        return projects.stream()
                .map(this::toDto)
                .toList();
    }
}
