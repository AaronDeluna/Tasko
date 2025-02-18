package org.javaacademy.tasko.mapper;

import org.javaacademy.tasko.dto.auth.LoginRequest;
import org.javaacademy.tasko.dto.auth.RegisterRequest;
import org.javaacademy.tasko.dto.user.UserDto;
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

    public UserDto toDto(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .build();
    }

}
