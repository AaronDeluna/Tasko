package org.javaacademy.tasko.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.javaacademy.tasko.entity.PriorityType;

import java.util.Date;

@Builder
@Getter
@Setter
public class CreateTaskDto {
    private String title;
    private String description;
    private Date dueDate;
    private PriorityType priority;
    private Integer taskColumn;
    private Integer position;
}
