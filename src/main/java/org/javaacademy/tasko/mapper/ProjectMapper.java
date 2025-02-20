package org.javaacademy.tasko.mapper;

import org.javaacademy.tasko.dto.project.CreateProjectDto;
import org.javaacademy.tasko.dto.project.CreateProjectDtoRes;
import org.javaacademy.tasko.dto.project.ProjectDto;
import org.javaacademy.tasko.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectMapper {
    Project toEntity(CreateProjectDto createProjectDto);
    @Mapping(source = "id", target = "id")
    CreateProjectDtoRes toDtoRes(Project entity);
    @Mapping(source = "id", target = "id")
    List<ProjectDto> toDtoList(List<Project> projects);
}
