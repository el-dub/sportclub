package com.creo.invention.dev.tsyw.controller;

import com.creo.invention.dev.tsyw.dto.ErrorDto;
import com.creo.invention.dev.tsyw.service.UserService;
import com.creo.invention.dev.tsyw.service.UserSubscriptionService;
import com.creo.invention.dev.tsyw.dto.usersubscription.CreateUserSubscriptionDto;
import com.creo.invention.dev.tsyw.dto.usersubscription.UserSubscriptionDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RestController
@RequestMapping("/user-subscriptions")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserSubscriptionController {

    private final UserSubscriptionService userSubscriptionService;
    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserSubscriptions(
            @RequestHeader("authorization") String token,
            @PathVariable UUID userId) {

        // TODO: create a filter to check admin rights
        if (!userService.isAdminWithToken(token.split(" ")[1].trim())) {
            return new ResponseEntity<>(
                    new ErrorDto(2, "Admin permissions required to access"),
                    HttpStatus.UNAUTHORIZED
            );
        }

        return ResponseEntity.ok(userSubscriptionService.getSubscriptionsByUserId(
                userId));
    }

    @PostMapping
    public UserSubscriptionDto createUserSubscription(@RequestBody CreateUserSubscriptionDto createUserSubscriptionDto) {
        return userSubscriptionService.addSubscriptionToUser(createUserSubscriptionDto);
    }


    @GetMapping("/visit/{userSubscriptionId}")
    public UserSubscriptionDto removeOneVisit(@PathVariable UUID userSubscriptionId) {
        return userSubscriptionService.removeOneVisit(userSubscriptionId);
    }

}
