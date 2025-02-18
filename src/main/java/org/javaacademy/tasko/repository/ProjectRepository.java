package org.javaacademy.tasko.repository;

import org.javaacademy.tasko.dto.project.ProjectDto;
import org.javaacademy.tasko.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Optional<List<Project>> findAllByUserId(Integer id);
    Optional<Project> deleteByIdAndUserId(Integer id, Integer userId);
}
