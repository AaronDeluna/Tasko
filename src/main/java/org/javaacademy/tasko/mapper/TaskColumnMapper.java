package org.javaacademy.tasko.mapper;

import org.javaacademy.tasko.dto.task_column.CreateTaskColumnDto;
import org.javaacademy.tasko.dto.task_column.CreateTaskColumnDtoRes;
import org.javaacademy.tasko.entity.TaskColumn;
import org.springframework.stereotype.Component;

@Component
public class TaskColumnMapper {

    public TaskColumn toEntity(CreateTaskColumnDto dto) {
        return new TaskColumn(
                dto.getName(),
                dto.getPosition()
        );
    }

    public CreateTaskColumnDtoRes toDtoRes(TaskColumn entity) {
        return CreateTaskColumnDtoRes.builder()
                .id(entity.getId())
                .name(entity.getName())
                .project(entity.getProject())
                .position(entity.getPosition())
                .build();
    }
}
