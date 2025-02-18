package org.javaacademy.tasko.service;

import org.javaacademy.tasko.dto.task.CreateTaskDto;
import org.javaacademy.tasko.dto.task.CreateTaskDtoRes;
import org.javaacademy.tasko.dto.task.TaskDto;
import org.javaacademy.tasko.entity.PriorityType;

import java.util.List;

public interface TaskService {
    CreateTaskDtoRes create(CreateTaskDto createTaskDto);
    List<TaskDto> findAllByProjectId();
    TaskDto findById(Integer id);
    void updateById(TaskDto taskDto);
    TaskDto updateColum(Integer colum);
    TaskDto updatePriority(PriorityType priorityType);
    void deleteById();
}
