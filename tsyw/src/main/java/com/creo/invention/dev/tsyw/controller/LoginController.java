package com.creo.invention.dev.tsyw.controller;

import com.creo.invention.dev.tsyw.dto.user.CreateUserDto;
import com.creo.invention.dev.tsyw.dto.user.LoginUserDto;
import com.creo.invention.dev.tsyw.exception.WrongCredentialsException;
import com.creo.invention.dev.tsyw.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LoginController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<?> authenticateUser(@RequestBody LoginUserDto dto) {
        try {
            return new ResponseEntity<>(service.validateUser(dto), HttpStatus.OK);
        } catch (WrongCredentialsException e) {
            return new ResponseEntity<>("{\"error\": 1}", HttpStatus.BAD_REQUEST);
        }
    }

}
