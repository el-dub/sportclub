package com.creo.invention.dev.tsyw.repository;

import com.creo.invention.dev.tsyw.model.UserSubscription;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, UUID> {

    @EntityGraph(attributePaths = {"subscription", "subscription.category"})
    List<UserSubscription> findAllByUserUserId(UUID userId);

    @Override
    @EntityGraph(attributePaths = {"subscription", "subscription.category"})
    UserSubscription save(UserSubscription userSubscription);
}
