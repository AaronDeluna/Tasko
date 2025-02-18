package org.javaacademy.tasko.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.javaacademy.tasko.entity.PriorityType;

@Builder
@Getter
@Setter
public class CreateTaskDtoRes {
    private Integer id;
    private String title;
    private Integer columId;
    private PriorityType priorityType;
}
