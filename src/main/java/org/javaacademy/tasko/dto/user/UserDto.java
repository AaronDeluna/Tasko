package org.javaacademy.tasko.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserDto {
    private Integer id;
    private String username;
    private String email;
    private String password;
}
