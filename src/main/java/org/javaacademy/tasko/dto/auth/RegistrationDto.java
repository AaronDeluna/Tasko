package org.javaacademy.tasko.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RegistrationDto {
    private String username;
    private String email;
    private String password;
}
