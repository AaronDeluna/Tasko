package org.javaacademy.tasko.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.javaacademy.tasko.dto.auth.JwtUserDto;
import org.javaacademy.tasko.entity.Token;
import org.javaacademy.tasko.entity.User;
import org.javaacademy.tasko.exception.InvalidTokenException;
import org.javaacademy.tasko.repository.TokenRepository;
import org.javaacademy.tasko.service.JwtTokenService;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtTokenServiceImpl implements JwtTokenService {
    private static final String CLAIM_USER_ID = "userId";
    private static final String CLAIM_USERNAME = "username";
    private static final String CLAIM_EMAIL = "email";
    private static final String SECRET = "2cESrxJodPImijMJUzz2Mb84X4+klEQXvIvLZ4hgpJc=";
    private static final Key JWT_SECRET = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;
    private static final long MILLISECONDS_IN_SECOND = 1000;
    private final TokenRepository tokenRepository;

    @Override
    public String generateToken(User user) {
        String tokenKay = Jwts.builder()
                .claim(CLAIM_USER_ID, user.getId())
                .claim(CLAIM_USERNAME, user.getUsername())
                .claim(CLAIM_EMAIL, user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(JWT_SECRET)
                .compact();

        LocalDateTime expiresAt = LocalDateTime.now().plusSeconds(EXPIRATION_TIME / MILLISECONDS_IN_SECOND);

        Token token = new Token(user, tokenKay, expiresAt);
        System.out.println(token);
        tokenRepository.save(token);
        return tokenKay;
    }

    @Override
    public JwtUserDto parseToken(String token) {
        if (!validateToken(token)) {
            throw new InvalidTokenException("Не валидный токен");
        }
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(JWT_SECRET)
                .build()
                .parseClaimsJws(token)
                .getBody();

        System.out.println("claims result: " + claims);
        return JwtUserDto.builder()
                .id(claims.get("userId", Integer.class))
                .username(claims.get("username", String.class))
                .email(claims.get("email", String.class))
                .build();
    }

    @Override
    public boolean validateToken(String checkToken) {
        Token token = tokenRepository.findByToken(checkToken).orElseThrow(
                () -> new InvalidTokenException("Не валидный токен")
        );

        if (token.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new InvalidTokenException("Токен истёк");
        }

        return true;
    }

}
