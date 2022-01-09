package com.creo.invention.dev.tsyw.controller;

import com.creo.invention.dev.tsyw.exception.WrongCredentialsException;
import com.creo.invention.dev.tsyw.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/my-info")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MyUserInfoController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<?> getUserInfo(@RequestHeader("authorization") String token) throws WrongCredentialsException {
        var userId = service.getUserIdFromToken(token.split(" ")[1].trim());
        return ResponseEntity.ok(service.getUserDetailsById(userId));
    }

}
