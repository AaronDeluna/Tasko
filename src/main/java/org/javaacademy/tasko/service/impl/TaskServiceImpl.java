package org.javaacademy.tasko.service.impl;

import lombok.RequiredArgsConstructor;
import org.javaacademy.tasko.dto.task.CreateTaskDto;
import org.javaacademy.tasko.dto.task.CreateTaskDtoRes;
import org.javaacademy.tasko.dto.task.TaskDto;
import org.javaacademy.tasko.entity.PriorityType;
import org.javaacademy.tasko.entity.Task;
import org.javaacademy.tasko.entity.TaskColumn;
import org.javaacademy.tasko.exception.NotFoundException;
import org.javaacademy.tasko.mapper.TaskMapper;
import org.javaacademy.tasko.repository.TaskColumnRepository;
import org.javaacademy.tasko.repository.TaskRepository;
import org.javaacademy.tasko.service.TaskColumnService;
import org.javaacademy.tasko.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskColumnService taskColumnService;
    private final TaskMapper taskMapper;

    @Override
    public CreateTaskDtoRes create(CreateTaskDto createTaskDto) {
        Task task = taskMapper.toEntity(createTaskDto);
        task.setTaskColumn(taskColumnService.findById(createTaskDto.getTaskColumn()));
        taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    @Override
    public List<TaskDto> findAllByProjectId() {
        return null;
    }

    @Override
    public TaskDto findById(Integer id) {
        return null;
    }

    @Override
    public void updateById(TaskDto taskDto) {

    }

    @Override
    public TaskDto updateColum(Integer colum) {
        return null;
    }

    @Override
    public TaskDto updatePriority(PriorityType priorityType) {
        return null;
    }

    @Override
    public void deleteById() {

    }
}
