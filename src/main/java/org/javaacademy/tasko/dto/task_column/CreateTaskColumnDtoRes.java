package org.javaacademy.tasko.dto.task_column;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.javaacademy.tasko.dto.task.TaskDto;
import org.javaacademy.tasko.entity.Project;

import java.util.List;

@Builder
@Getter
@Setter
public class CreateTaskColumnDtoRes {
    private Integer id;
    private String name;
    private Project project;
    private Integer position;
    private List<TaskDto> tasks;

}
