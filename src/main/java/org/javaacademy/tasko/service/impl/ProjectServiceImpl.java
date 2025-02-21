package org.javaacademy.tasko.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.tasko.dto.project.CreateProjectDto;
import org.javaacademy.tasko.dto.project.CreateProjectDtoRes;
import org.javaacademy.tasko.dto.project.ProjectDto;
import org.javaacademy.tasko.entity.Project;
import org.javaacademy.tasko.entity.User;
import org.javaacademy.tasko.exception.NotFoundException;
import org.javaacademy.tasko.mapper.ProjectMapper;
import org.javaacademy.tasko.mapper.UserMapper;
import org.javaacademy.tasko.repository.ProjectRepository;
import org.javaacademy.tasko.repository.UserRepository;
import org.javaacademy.tasko.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private static final String EMAIL_NOT_FOUND_MESSAGE = "Ошибка: пользователь с email: %s не найден";
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;
    private final UserMapper userMapper;

    @Override
    public CreateProjectDtoRes create(String email, CreateProjectDto createProjectDto) {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new NotFoundException(EMAIL_NOT_FOUND_MESSAGE.formatted(email))
        );

        Project project = projectMapper.toEntity(createProjectDto);
        project.setUser(user);
        projectRepository.save(project);
        CreateProjectDtoRes createProjectDtoRes = projectMapper.toDtoRes(project);
        createProjectDtoRes.setUserDtoRes(userMapper.toDtoRes(user));
        return createProjectDtoRes;
    }

    @Override
    public ProjectDto update(String email, ProjectDto projectDto) {
        return null;
    }

    @Override
    public void deleteById(String email, Integer projectId) {
        Project project = projectRepository.findByIdAndUserEmail(projectId, email).orElseThrow(
                () -> new NotFoundException("Проект с id: %s не найден".formatted(projectId))
        );

        projectRepository.delete(project);
    }

    @Override
    public List<ProjectDto> findAllByEmail(String email) {
        return projectMapper.toDtoList(projectRepository.findAllByUserEmail(email));
    }
}
