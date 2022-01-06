package com.creo.invention.dev.tsyw.dto.mapper;

import com.creo.invention.dev.tsyw.dto.user.CreateUserDto;
import com.creo.invention.dev.tsyw.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromCreateDto(CreateUserDto createDto);

}
