package org.javaacademy.tasko.dto.task_column;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.javaacademy.tasko.entity.Project;

@Builder
@Getter
@Setter
public class TaskColumnDto {
    private String name;
    private Project project;
    private Integer position;

}
