package org.javaacademy.tasko.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class JwtUserDto {
    private Integer id;
    private String username;
    private String email;
}
