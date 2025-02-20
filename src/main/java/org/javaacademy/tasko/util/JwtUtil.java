package org.javaacademy.tasko.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.experimental.UtilityClass;

import java.security.Key;
import java.util.Date;

@UtilityClass
public class JwtUtil {
//    private static final Key JWT_SECRET = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//    private static final long EXPIRATION_TIME = 86400000;
//
//    public String generateToken(UserDto userDto) {
//        return Jwts.builder()
//                .claim("userId", userDto.getId())
//                .claim("username", userDto.getUsername())
//                .claim("email", userDto.getEmail())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(JWT_SECRET)
//                .compact();
//    }
//
//    public UserDto parseToken(String token) {
//        Claims claims = Jwts.parserBuilder()
//                .setSigningKey(JWT_SECRET)
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//
//        return UserDto.builder()
//                .id(claims.get("userId", Integer.class))
//                .username(claims.get("username", String.class))
//                .email(claims.get("email", String.class))
//                .build();
//    }
//
//    public boolean validateToken(String token) {
//        return false;
//    }

}
