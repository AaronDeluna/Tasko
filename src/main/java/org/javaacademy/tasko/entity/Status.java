package org.javaacademy.tasko.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    NEW("Новая"),
    IN_PROGRESS("В процессе"),
    COMPLETED("Завершена"),
    CANCELED("Отменена");

    private final String description;
}
