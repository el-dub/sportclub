package com.creo.invention.dev.tsyw.controller;

import com.creo.invention.dev.tsyw.exception.WrongCredentialsException;
import com.creo.invention.dev.tsyw.service.UserService;
import com.creo.invention.dev.tsyw.service.UserSubscriptionService;
import com.creo.invention.dev.tsyw.dto.usersubscription.CreateUserSubscriptionDto;
import com.creo.invention.dev.tsyw.dto.usersubscription.UserSubscriptionDto;
import com.creo.invention.dev.tsyw.service.UserSubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user-subscriptions")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserSubscriptionController {

    private final UserSubscriptionService userSubscriptionService;
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



    private final UserSubscriptionService userSubscriptionService;

    @PostMapping
    public UserSubscriptionDto createUserSubscription(@RequestBody CreateUserSubscriptionDto createUserSubscriptionDto) {
        return userSubscriptionService.addSubscriptionToUser(createUserSubscriptionDto);
    }

    @GetMapping("/{userId}")
    public List<UserSubscriptionDto> getUserSubscriptionsByUserId(@PathVariable UUID userId) {
        return userSubscriptionService.getSubscriptionsByUserId(userId);
    }

    @GetMapping("/visit/{userSubscriptionId}")
    public UserSubscriptionDto removeOneVisit(@PathVariable UUID userSubscriptionId) {
        return userSubscriptionService.removeOneVisit(userSubscriptionId);
    }
}
