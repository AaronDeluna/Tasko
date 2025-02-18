package org.javaacademy.tasko.repository;

import org.javaacademy.tasko.entity.TaskColumn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskColumnRepository extends JpaRepository<TaskColumn, Integer> {
}
