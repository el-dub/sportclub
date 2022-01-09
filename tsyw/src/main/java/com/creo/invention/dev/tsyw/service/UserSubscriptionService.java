package com.creo.invention.dev.tsyw.service;

import com.creo.invention.dev.tsyw.dto.usersubscription.CreateUserSubscriptionDto;
import com.creo.invention.dev.tsyw.dto.usersubscription.UpdateUserSubscriptionDto;
import com.creo.invention.dev.tsyw.dto.usersubscription.UserSubscriptionDto;

import java.util.List;
import java.util.UUID;

public interface UserSubscriptionService {

    UserSubscriptionDto addSubscriptionToUser(CreateUserSubscriptionDto createUserSubscriptionDto);

    List<UserSubscriptionDto> getSubscriptionsByUserId(UUID userId);

    UserSubscriptionDto removeOneVisit(UUID userSubscriptionId);

    void deleteUserSubscription(UUID userSubscriptionId);

    void updateUserSubscription(UpdateUserSubscriptionDto dto);
}
