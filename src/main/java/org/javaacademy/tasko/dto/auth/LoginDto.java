package org.javaacademy.tasko.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LoginDto {
    private String email;
    private String password;
}
