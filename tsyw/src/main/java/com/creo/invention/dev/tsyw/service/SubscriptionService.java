package com.creo.invention.dev.tsyw.service;

import com.creo.invention.dev.tsyw.dto.subscription.SubscriptionDto;
import com.creo.invention.dev.tsyw.dto.subscription.CreateSubscriptionDto;

import java.util.List;
import java.util.UUID;

public interface SubscriptionService {

    List<SubscriptionDto> getAll();

    SubscriptionDto addNewSubscription(CreateSubscriptionDto createSubscriptionDto);

    void deleteSubscriptionById(UUID subscriptionId);

    SubscriptionDto updateSubscription(SubscriptionDto subscriptionDto);
}
