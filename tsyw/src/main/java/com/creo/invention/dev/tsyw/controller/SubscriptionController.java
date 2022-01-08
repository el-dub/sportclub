package com.creo.invention.dev.tsyw.controller;

import com.creo.invention.dev.tsyw.dto.subscription.CreateSubscriptionDto;
import com.creo.invention.dev.tsyw.dto.subscription.SubscriptionDto;
import com.creo.invention.dev.tsyw.dto.subscription.UpdateSubscriptionDto;
import com.creo.invention.dev.tsyw.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @GetMapping
    public List<SubscriptionDto> getAll() {
        return subscriptionService.getAll();
    }

    @PostMapping
    public SubscriptionDto addNewSubscription(@RequestBody CreateSubscriptionDto createSubscriptionDto) {
        return subscriptionService.addNewSubscription(createSubscriptionDto);
    }

    @PutMapping
    public List<SubscriptionDto> updateSubscriptions(@RequestBody List<UpdateSubscriptionDto> updateSubscriptionDtoList) {
        return subscriptionService.updateSubscriptions(updateSubscriptionDtoList);
    }

    @DeleteMapping("/{subscriptionId}")
    public void deleteSubscription(@PathVariable UUID subscriptionId) {
        subscriptionService.deleteSubscriptionById(subscriptionId);
    }
}
