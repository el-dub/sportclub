package com.creo.invention.dev.tsyw.controller;

import com.creo.invention.dev.tsyw.dto.user.CreateUserDto;
import com.creo.invention.dev.tsyw.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService service;

    @PostMapping
    public String createUser(@RequestBody CreateUserDto dto) {
        return service.createUser(dto);
    }


}
