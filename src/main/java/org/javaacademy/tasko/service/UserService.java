package org.javaacademy.tasko.service;

import org.javaacademy.tasko.dto.user.UserDto;

public interface UserService {
    UserDto findUserById(Integer id);
}
