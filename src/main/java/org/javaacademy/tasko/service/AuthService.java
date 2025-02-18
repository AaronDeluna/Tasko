package org.javaacademy.tasko.service;

import org.javaacademy.tasko.dto.auth.LoginRequest;
import org.javaacademy.tasko.dto.auth.RegisterRequest;

public interface AuthService {
    String login(LoginRequest loginRequest);
    void register(RegisterRequest registerRequest);
}
