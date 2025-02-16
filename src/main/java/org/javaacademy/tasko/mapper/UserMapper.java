package org.javaacademy.tasko.mapper;

import org.javaacademy.tasko.dto.auth.RegisterRequest;
import org.javaacademy.tasko.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(RegisterRequest registerRequest) {
        return new User(
                registerRequest.getUsername(),
                registerRequest.getEmail(),
                registerRequest.getPassword()
        );
    }
}
