package org.javaacademy.tasko.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateProjectDto {
    private String name;
    private String description;
}
