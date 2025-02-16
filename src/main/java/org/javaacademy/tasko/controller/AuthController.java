package org.javaacademy.tasko.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.tasko.dto.auth.LoginRequest;
import org.javaacademy.tasko.dto.auth.RegisterRequest;
import org.javaacademy.tasko.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok().body(authService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> register(@RequestBody RegisterRequest registerRequest) {
        authService.create(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
