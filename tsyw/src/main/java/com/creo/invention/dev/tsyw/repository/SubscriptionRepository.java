package com.creo.invention.dev.tsyw.repository;

import com.creo.invention.dev.tsyw.model.Subscription;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {

    @EntityGraph(attributePaths = "category")
    List<Subscription> findAll();

    @EntityGraph(attributePaths = "category")
    Optional<Subscription> findById(UUID id);

    @EntityGraph(attributePaths = "category")
    Subscription save(Subscription subscription);
}
