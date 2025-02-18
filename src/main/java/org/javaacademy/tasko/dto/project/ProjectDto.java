package org.javaacademy.tasko.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ProjectDto {
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime createAt;

}
