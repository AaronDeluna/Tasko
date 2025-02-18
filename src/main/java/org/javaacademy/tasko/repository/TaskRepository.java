package org.javaacademy.tasko.repository;

import org.javaacademy.tasko.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
