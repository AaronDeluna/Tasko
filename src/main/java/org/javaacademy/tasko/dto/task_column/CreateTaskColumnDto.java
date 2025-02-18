package org.javaacademy.tasko.dto.task_column;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateTaskColumnDto {
    private String name;
    private Integer projectId;
    private Integer position;

}
