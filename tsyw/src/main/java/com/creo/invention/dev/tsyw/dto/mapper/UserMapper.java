package com.creo.invention.dev.tsyw.dto.mapper;

import com.creo.invention.dev.tsyw.dto.user.CreateUserDto;
import com.creo.invention.dev.tsyw.dto.user.UserDto;
import com.creo.invention.dev.tsyw.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromCreateDto(CreateUserDto createDto);

    @Mapping(source = "role.roleName", target = "role")
    UserDto toDto(User user);

}
