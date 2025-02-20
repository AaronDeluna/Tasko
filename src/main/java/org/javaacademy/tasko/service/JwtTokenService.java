package org.javaacademy.tasko.service;

import org.javaacademy.tasko.dto.auth.JwtUserDto;
import org.javaacademy.tasko.entity.User;

public interface JwtTokenService {
    String generateToken(User user);
    JwtUserDto parseToken(String token);
    boolean validateToken(String token);
}
