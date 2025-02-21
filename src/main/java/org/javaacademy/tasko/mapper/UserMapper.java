package org.javaacademy.tasko.mapper;

import org.javaacademy.tasko.dto.auth.RegistrationDto;
import org.javaacademy.tasko.dto.user.UserDtoRes;
import org.javaacademy.tasko.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "projects", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    User convertToEntity(RegistrationDto dto);
    UserDtoRes toDtoRes(User entity);
}
