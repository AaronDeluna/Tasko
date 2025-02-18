package org.javaacademy.tasko.service.impl;

import lombok.RequiredArgsConstructor;
import org.javaacademy.tasko.dto.task_column.CreateTaskColumnDto;
import org.javaacademy.tasko.dto.task_column.CreateTaskColumnDtoRes;
import org.javaacademy.tasko.entity.TaskColumn;
import org.javaacademy.tasko.exception.NotFoundException;
import org.javaacademy.tasko.mapper.TaskColumnMapper;
import org.javaacademy.tasko.repository.ProjectRepository;
import org.javaacademy.tasko.repository.TaskColumnRepository;
import org.javaacademy.tasko.service.TaskColumnService;
import org.springframework.stereotype.Service;

import java.util.Collections;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
public class TaskColumnServiceImpl implements TaskColumnService {
    private final TaskColumnRepository taskColumnRepository;
    private final TaskColumnMapper taskColumnMapper;
    private final ProjectRepository projectRepository;

    @Override
    public CreateTaskColumnDtoRes create(CreateTaskColumnDto createTaskColumnDto) {
        TaskColumn taskColumn = taskColumnMapper.toEntity(createTaskColumnDto);
        taskColumn.setProject(projectRepository.findById(createTaskColumnDto.getProjectId()).orElseThrow());
        taskColumn.setTasks(emptyList());
        taskColumnRepository.save(taskColumn);

        CreateTaskColumnDtoRes createTaskColumnDtoRes = taskColumnMapper.toDtoRes(taskColumn);
        createTaskColumnDtoRes.setTasks(emptyList());
        return createTaskColumnDtoRes;
    }

    @Override
    public TaskColumn findById(Integer id) {
        return taskColumnRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Колонка %s не найдена".formatted(id))
        );
    }
}
