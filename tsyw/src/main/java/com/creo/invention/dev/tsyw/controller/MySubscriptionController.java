package com.creo.invention.dev.tsyw.controller;

import com.creo.invention.dev.tsyw.dto.usersubscription.UserSubscriptionDto;
import com.creo.invention.dev.tsyw.exception.WrongCredentialsException;
import com.creo.invention.dev.tsyw.service.UserService;
import com.creo.invention.dev.tsyw.service.UserSubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/my-subscriptions")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MySubscriptionController {


    private final UserSubscriptionService userSubscriptionService;
    private final UserService userService;

    @GetMapping
    public List<UserSubscriptionDto> getUserSubscriptions(@RequestHeader("authorization") String token) {
        try {
            var userId = userService.getUserIdFromToken(token.split(" ")[1].trim());
            return userSubscriptionService.getSubscriptionsByUserId(userId);
        } catch (WrongCredentialsException e) {
            return null;
        }
    }

}
