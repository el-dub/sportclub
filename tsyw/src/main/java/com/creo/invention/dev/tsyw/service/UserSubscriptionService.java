package com.creo.invention.dev.tsyw.service;

import com.creo.invention.dev.tsyw.dto.usersubscription.CreateUserSubscriptionDto;
import com.creo.invention.dev.tsyw.dto.usersubscription.UserSubscriptionDto;

import java.util.List;
import java.util.UUID;

public interface UserSubscriptionService {

    UserSubscriptionDto addSubscriptionToUser(UUID userId, CreateUserSubscriptionDto createUserSubscriptionDto);

    List<UserSubscriptionDto> getSubscriptionsByUserId(UUID userId);

    UserSubscriptionDto removeOneVisit(UUID userSubscriptionId);
}
