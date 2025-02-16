package org.javaacademy.tasko.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.tasko.entity.User;
import org.javaacademy.tasko.exception.NotFoundException;
import org.javaacademy.tasko.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final static String USER_NOT_FOUND_MESSAGE = "Пользователь с email: %s не найден";
    private final UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new NotFoundException(USER_NOT_FOUND_MESSAGE.formatted(email)));
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
