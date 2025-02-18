package org.javaacademy.tasko.mapper;

import org.javaacademy.tasko.dto.task.CreateTaskDto;
import org.javaacademy.tasko.dto.task.CreateTaskDtoRes;
import org.javaacademy.tasko.dto.task.TaskDto;
import org.javaacademy.tasko.entity.PriorityType;
import org.javaacademy.tasko.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task toEntity(CreateTaskDto createTaskDto) {
        return new Task(
                createTaskDto.getTitle(),
                createTaskDto.getDescription(),
                createTaskDto.getDueDate(),
                createTaskDto.getPriority(),
                createTaskDto.getPosition()
        );
    }

    public CreateTaskDtoRes toDto(Task entity) {
        return CreateTaskDtoRes.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .columId(entity.getId())
                .priorityType(entity.getPriority())
                .build();
    }

}
