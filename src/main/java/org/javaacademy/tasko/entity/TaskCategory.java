package org.javaacademy.tasko.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskCategory {
    BUG("Баг"),
    FEATURE("Функция"),
    TECHNICAL("Техническая задача"),
    DOCUMENTATION("Документация");

    private final String description;
}
