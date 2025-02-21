package org.javaacademy.tasko.service;

import org.javaacademy.tasko.dto.auth.LoginDto;
import org.javaacademy.tasko.dto.auth.RegistrationDto;

public interface AuthService {
    void registration(RegistrationDto registrationDto);
    String login(LoginDto loginDto);

}
