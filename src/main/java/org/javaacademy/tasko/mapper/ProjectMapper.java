package org.javaacademy.tasko.mapper;

import org.javaacademy.tasko.dto.project.CreateProjectDto;
import org.javaacademy.tasko.dto.project.CreateProjectDtoRes;
import org.javaacademy.tasko.dto.project.ProjectDto;
import org.javaacademy.tasko.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {UserMapper.class}
)
public interface ProjectMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "containers", ignore = true)
    Project toEntity(CreateProjectDto createProjectDto);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "user", target = "userDtoRes")
    CreateProjectDtoRes toDtoRes(Project entity);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "user", target = "userDtoRes")
    List<ProjectDto> toDtoList(List<Project> projects);
}
