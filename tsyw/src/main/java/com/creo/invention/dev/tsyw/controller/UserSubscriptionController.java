package com.creo.invention.dev.tsyw.controller;

import com.creo.invention.dev.tsyw.exception.WrongCredentialsException;
import com.creo.invention.dev.tsyw.service.UserService;
import com.creo.invention.dev.tsyw.service.UserSubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-subscriptions")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserSubscriptionController {

    private final UserSubscriptionService service;
    private final UserService userService;

    @GetMapping
    String getUserSubscriptions(@RequestHeader("authorization") String token) {
        try {
            var user = userService.getUserFromToken(token.split(" ")[1].trim());
            // todo
            return user.getFirstName();
        } catch (WrongCredentialsException e) {
            return "{\"error\": 1}";
        }
    }


}
