package org.javaacademy.tasko.service.impl;

import lombok.RequiredArgsConstructor;
import org.javaacademy.tasko.entity.TaskColumn;
import org.javaacademy.tasko.exception.NotFoundException;
import org.javaacademy.tasko.repository.TaskColumnRepository;
import org.javaacademy.tasko.service.TaskColumnService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskColumnServiceImpl implements TaskColumnService {
    private final TaskColumnRepository taskColumnRepository;

    @Override
    public TaskColumn findById(Integer id) {
        return taskColumnRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Колонка %s не найдена".formatted(id))
        );
    }
}
