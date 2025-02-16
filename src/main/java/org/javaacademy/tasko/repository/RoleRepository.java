package org.javaacademy.tasko.repository;

import org.javaacademy.tasko.entity.Role;
import org.javaacademy.tasko.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(UserRole name);
}
