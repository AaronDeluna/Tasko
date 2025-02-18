package org.javaacademy.tasko.service.impl;

import lombok.RequiredArgsConstructor;
import org.javaacademy.tasko.dto.auth.LoginRequest;
import org.javaacademy.tasko.dto.auth.RegisterRequest;
import org.javaacademy.tasko.dto.user.UserDto;
import org.javaacademy.tasko.entity.User;
import org.javaacademy.tasko.exception.NotFoundException;
import org.javaacademy.tasko.exception.PasswordNotCorrectException;
import org.javaacademy.tasko.mapper.UserMapper;
import org.javaacademy.tasko.repository.UserRepository;
import org.javaacademy.tasko.service.AuthService;
import org.javaacademy.tasko.util.JwtUtil;
import org.javaacademy.tasko.util.PasswordUtil;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public String login(LoginRequest loginRequest) {
        UserDto userDto = userMapper.toDto(userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(
                () -> new NotFoundException("%s не найден")
        ));

        if (!PasswordUtil.checkPassword(loginRequest.getPassword(), userDto.getPassword())) {
            throw new PasswordNotCorrectException("Пароль не верный!");
        }

        return JwtUtil.generateToken(userDto);
    }

    public void register(RegisterRequest registerRequest) {
        User user = userMapper.toEntity(registerRequest);
        user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
        userRepository.save(user);
    }
}
