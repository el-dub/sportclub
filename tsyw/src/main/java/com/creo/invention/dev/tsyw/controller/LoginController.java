package com.creo.invention.dev.tsyw.controller;

import com.creo.invention.dev.tsyw.dto.user.CreateUserDto;
import com.creo.invention.dev.tsyw.dto.user.LoginUserDto;
import com.creo.invention.dev.tsyw.exception.WrongCredentialsException;
import com.creo.invention.dev.tsyw.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final UserService service;

    @PostMapping
    public String authenticateUser(@RequestBody LoginUserDto dto) {
        try {
            return service.validateUser(dto);
        } catch (WrongCredentialsException e) {
            return "{\"error\": 1}";
        }
    }

}
