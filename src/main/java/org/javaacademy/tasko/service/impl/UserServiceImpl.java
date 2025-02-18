package org.javaacademy.tasko.service.impl;

import lombok.RequiredArgsConstructor;
import org.javaacademy.tasko.dto.user.UserDto;
import org.javaacademy.tasko.exception.NotFoundException;
import org.javaacademy.tasko.mapper.UserMapper;
import org.javaacademy.tasko.repository.UserRepository;
import org.javaacademy.tasko.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto findUserById(Integer id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User с id: %s не найден"))
        );
    }
}
