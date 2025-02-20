package org.javaacademy.tasko.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.tasko.dto.auth.JwtUserDto;
import org.javaacademy.tasko.dto.auth.LoginDto;
import org.javaacademy.tasko.dto.auth.RegistrationDto;
import org.javaacademy.tasko.entity.User;
import org.javaacademy.tasko.exception.NotFoundException;
import org.javaacademy.tasko.exception.PasswordNotCorrectException;
import org.javaacademy.tasko.mapper.UserMapper;
import org.javaacademy.tasko.repository.UserRepository;
import org.javaacademy.tasko.service.AuthService;
import org.javaacademy.tasko.util.JwtUtil;
import org.javaacademy.tasko.util.PasswordUtil;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public void registration(RegistrationDto registrationDto) {
        User user = userMapper.convertToEntity(registrationDto);
        user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
        user.setProjects(emptyList());
        userRepository.save(user);
    }

    @Override
    public String login(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(
                () -> new NotFoundException("email: %s не найден".formatted(loginDto.getEmail()))
        );

        if (!PasswordUtil.checkPassword(loginDto.getPassword(), user.getPassword())) {
            throw new PasswordNotCorrectException("Не корректный пароль");
        }

        return JwtUtil.generateToken(JwtUserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build());
    }
}
