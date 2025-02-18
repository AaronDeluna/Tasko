package org.javaacademy.tasko.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.tasko.dto.project.CreateProjectDto;
import org.javaacademy.tasko.dto.project.CreateProjectDtoRes;
import org.javaacademy.tasko.dto.project.ProjectDto;
import org.javaacademy.tasko.entity.Project;
import org.javaacademy.tasko.exception.NotFoundException;
import org.javaacademy.tasko.mapper.ProjectMapper;
import org.javaacademy.tasko.repository.ProjectRepository;
import org.javaacademy.tasko.repository.UserRepository;
import org.javaacademy.tasko.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final UserRepository userRepository;

    @Override
    public CreateProjectDtoRes create(Integer userId, CreateProjectDto createProjectDto) {
        Project project = projectMapper.toEntity(createProjectDto);
        project.setUser(userRepository.findById(userId).orElseThrow());
        projectRepository.save(project);
        return projectMapper.toDtoRes(project);
    }

    @Override
    public List<ProjectDto> findAll(Integer userId) {
        return projectMapper.toDtoList(projectRepository.findAllByUserId(userId).orElse(emptyList()));
    }

    @Override
    public ProjectDto updateById(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id, Integer userId) {
        projectRepository.deleteByIdAndUserId(id, userId).orElseThrow(
                () -> new NotFoundException("Проект с id: %s не найден".formatted(id))
        );
    }
}
