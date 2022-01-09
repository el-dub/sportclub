package com.creo.invention.dev.tsyw.controller;

import com.creo.invention.dev.tsyw.dto.user.CreateUserDto;
import com.creo.invention.dev.tsyw.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserInfo(@PathVariable UUID userId) {
        // TODO: validate admin rights
        return ResponseEntity.ok(service.getUserDetailsById(userId));
    }


}
