package com.creo.invention.dev.tsyw.service;

import com.creo.invention.dev.tsyw.dto.usersubscription.CreateUserSubscriptionDto;
import com.creo.invention.dev.tsyw.dto.usersubscription.UserSubscriptionDto;

public interface UserSubscriptionService {

    UserSubscriptionDto addSubscriptionToUser(CreateUserSubscriptionDto createUserSubscriptionDto);
}
