package com.creo.invention.dev.tsyw.repository;

import com.creo.invention.dev.tsyw.model.UserSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, UUID> {
}
