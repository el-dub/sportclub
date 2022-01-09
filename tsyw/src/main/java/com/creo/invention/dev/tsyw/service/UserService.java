package com.creo.invention.dev.tsyw.service;

import com.creo.invention.dev.tsyw.dto.user.CreateUserDto;
import com.creo.invention.dev.tsyw.dto.user.LoginUserDto;
import com.creo.invention.dev.tsyw.dto.user.UserDto;
import com.creo.invention.dev.tsyw.exception.WrongCredentialsException;
import com.creo.invention.dev.tsyw.model.User;

import java.util.UUID;

public interface UserService {

    /**
     * @return jwt token
     */
    String createUser(CreateUserDto dto);

    /**
     * @return jwt token
     */
    String validateUser(LoginUserDto dto) throws WrongCredentialsException;

    User getUserFromToken(String token) throws WrongCredentialsException;

    UUID getUserIdFromToken(String token) throws WrongCredentialsException;

    boolean isAdminWithToken(String token);

    UserDto getUserDetailsById(UUID id);

}
