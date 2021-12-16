package com.creo.invention.dev.tsyw.controller;

import com.creo.invention.dev.tsyw.dto.SubscriptionDto;
import com.creo.invention.dev.tsyw.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @GetMapping
    public List<SubscriptionDto> getAll() {
        return subscriptionService.getAll();
    }
}
