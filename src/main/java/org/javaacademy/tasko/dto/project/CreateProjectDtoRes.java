package org.javaacademy.tasko.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.javaacademy.tasko.dto.user.UserDtoRes;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString
public class CreateProjectDtoRes {
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime createAt;
    private UserDtoRes userDtoRes;
}
