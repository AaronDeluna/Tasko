package org.javaacademy.tasko.dto.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javaacademy.tasko.dto.user.UserDtoRes;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime createAt;
    private UserDtoRes userDtoRes;

}
