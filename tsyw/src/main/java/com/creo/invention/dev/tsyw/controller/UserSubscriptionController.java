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
@CrossOrigin(origins = "*")
public class UserSubscriptionController {

    private final UserSubscriptionService userSubscriptionService;
    private final UserService userService;

    @GetMapping
    List<UserSubscriptionDto> getUserSubscriptions(@RequestHeader("authorization") String token) {
        try {
            var userId = userService.getUserIdFromToken(token.split(" ")[1].trim());
            return userSubscriptionService.getSubscriptionsByUserId(userId);
        } catch (WrongCredentialsException e) {
            return null;
        }
    }

    @PostMapping
    public UserSubscriptionDto createUserSubscription(@RequestHeader("authorization") String token, @RequestBody CreateUserSubscriptionDto createUserSubscriptionDto) throws WrongCredentialsException {
        var userId = userService.getUserIdFromToken(token.split(" ")[1].trim());
        return userSubscriptionService.addSubscriptionToUser(userId, createUserSubscriptionDto);
    }


    @GetMapping("/visit/{userSubscriptionId}")
    public UserSubscriptionDto removeOneVisit(@PathVariable UUID userSubscriptionId) {
        return userSubscriptionService.removeOneVisit(userSubscriptionId);
    }
}
