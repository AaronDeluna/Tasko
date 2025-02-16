package org.javaacademy.tasko.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.tasko.dto.auth.LoginRequest;
import org.javaacademy.tasko.dto.auth.RegisterRequest;
import org.javaacademy.tasko.entity.User;
import org.javaacademy.tasko.entity.UserRole;
import org.javaacademy.tasko.exception.PasswordNotCorrectException;
import org.javaacademy.tasko.mapper.UserMapper;
import org.javaacademy.tasko.repository.RoleRepository;
import org.javaacademy.tasko.util.PasswordUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final static String NOT_CORRECT_PASSWORD_MESSAGE = "Пароль не верный, попробуйте в другой раз!";
    private final RoleRepository roleRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserMapper userMapper;
    private final UserService userService;

    public String login(LoginRequest loginRequest) {
        User user = userService.findByEmail(loginRequest.getEmail());
        if (!PasswordUtil.checkPassword(loginRequest.getPassword(), user.getPassword())) {
            throw new PasswordNotCorrectException(NOT_CORRECT_PASSWORD_MESSAGE);
        }

        return jwtTokenProvider.generateToken(loginRequest.getEmail(), user.getRole().getName());
    }

    public void create(RegisterRequest registerRequest) {
        User user = userMapper.toEntity(registerRequest);
        user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
        user.setRole(roleRepository.findByName(UserRole.USER).orElse(null));
        userService.save(user);
    }
}
