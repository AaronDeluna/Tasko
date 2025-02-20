package org.javaacademy.tasko.mapper;

import org.javaacademy.tasko.dto.auth.RegistrationDto;
import org.javaacademy.tasko.dto.user.UserDtoRes;
import org.javaacademy.tasko.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User convertToEntity(RegistrationDto dto);
    UserDtoRes toDtoRes(User entity);
}
