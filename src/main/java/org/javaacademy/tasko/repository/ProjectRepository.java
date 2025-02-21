package org.javaacademy.tasko.repository;

import org.javaacademy.tasko.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Optional<Project> findByIdAndUserEmail(Integer projectId, String email);
    List<Project> findAllByUserEmail(String email);
}
