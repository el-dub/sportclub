package com.creo.invention.dev.tsyw.service.impl;

import com.creo.invention.dev.tsyw.dto.subscription.SubscriptionDto;
import com.creo.invention.dev.tsyw.dto.mapper.SubscriptionMapper;
import com.creo.invention.dev.tsyw.dto.subscription.CreateSubscriptionDto;
import com.creo.invention.dev.tsyw.dto.subscription.UpdateSubscriptionDto;
import com.creo.invention.dev.tsyw.exception.NotFoundException;
import com.creo.invention.dev.tsyw.model.Category;
import com.creo.invention.dev.tsyw.model.Subscription;
import com.creo.invention.dev.tsyw.repository.CategoryRepository;
import com.creo.invention.dev.tsyw.repository.SubscriptionRepository;
import com.creo.invention.dev.tsyw.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionMapper subscriptionMapper;

    private final SubscriptionRepository subscriptionRepository;

    private final CategoryRepository categoryRepository;

    @Override
    public List<SubscriptionDto> getAll() {
        return subscriptionMapper.toDtoList(subscriptionRepository.findAll());
    }

    @Override
    public SubscriptionDto addNewSubscription(CreateSubscriptionDto createSubscriptionDto) {
        Category category = findCategoryById(createSubscriptionDto.getCategoryId());
        Subscription subscription = subscriptionMapper.fromCreateDto(createSubscriptionDto);
        subscription.setCategory(category);
        return subscriptionMapper.toDto(subscriptionRepository.save(subscription));
    }

    @Override
    public void deleteSubscriptionById(UUID subscriptionId) {
        subscriptionRepository.deleteById(subscriptionId);
    }

    @Override
    public SubscriptionDto updateSubscription(UpdateSubscriptionDto updateSubscriptionDto) {
        UUID subscriptionId = updateSubscriptionDto.getSubscriptionId();
        if (!subscriptionRepository.existsById(subscriptionId)) {
            throw new NotFoundException(String.format("Subscription with id %s not found", subscriptionId));
        }
        Category category = findCategoryById(updateSubscriptionDto.getCategoryId());
        Subscription subscription = subscriptionMapper.fromUpdateDto(updateSubscriptionDto);
        subscription.setCategory(category);

        return subscriptionMapper.toDto(subscriptionRepository.save(subscription));
    }

    private Category findCategoryById(UUID categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException(String.format("Category with id %s not found", categoryId)));
    }

    private Subscription findSubscriptionById(UUID subscriptionId) {
        return subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new NotFoundException(String.format("Subscription with id %s not found", subscriptionId)));
    }
}
