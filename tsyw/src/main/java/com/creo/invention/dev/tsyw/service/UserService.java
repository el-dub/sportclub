package com.creo.invention.dev.tsyw.service;

import com.creo.invention.dev.tsyw.dto.user.CreateUserDto;

public interface UserService {

    /**
     * @return jwt token
     */
    String createUser(CreateUserDto dto);

}
