package com.creo.invention.dev.tsyw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-subscriptions")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserSubscriptionController {
}
