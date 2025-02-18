package org.javaacademy.tasko.service;

import org.javaacademy.tasko.dto.task_column.CreateTaskColumnDto;
import org.javaacademy.tasko.dto.task_column.CreateTaskColumnDtoRes;
import org.javaacademy.tasko.entity.TaskColumn;

public interface TaskColumnService {
    CreateTaskColumnDtoRes create(CreateTaskColumnDto createTaskColumnDto);
    TaskColumn findById(Integer id);
}
