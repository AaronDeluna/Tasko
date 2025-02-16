package org.javaacademy.tasko.service;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.javaacademy.tasko.entity.UserRole;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenProvider {
    @Value("${jwt.token}")
    private String jwtSecret;

    public String generateToken(String email, UserRole userRole) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", userRole.name())
                .signWith(Keys.secretKeyFor(SignatureAlgorithm.HS512))
                .compact();
    }

    public String getEmailFromToken(String token) {
        JwtParser parser = Jwts.parser() // Используем новый способ создания парсера
                .setSigningKey(jwtSecret)          // Устанавливаем секретный ключ
                .build();
        return parser.parseClaimsJws(token).getBody().getSubject(); // Извлекаем имя пользователя
    }

    // Валидация токена
    public boolean validateToken(String token) {
        try {
            JwtParser parser = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .build();
            parser.parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
