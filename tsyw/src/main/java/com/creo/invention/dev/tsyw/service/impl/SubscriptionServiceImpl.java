package com.creo.invention.dev.tsyw.service.impl;

import com.creo.invention.dev.tsyw.dto.SubscriptionDto;
import com.creo.invention.dev.tsyw.dto.mapper.SubscriptionMapper;
import com.creo.invention.dev.tsyw.repository.SubscriptionRepository;
import com.creo.invention.dev.tsyw.service.SubscriptionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionMapper subscriptionMapper;

    private final SubscriptionRepository subscriptionRepository;

    @Override
    public List<SubscriptionDto> getAll() {
        return subscriptionMapper.toDtoList(subscriptionRepository.findAll());
    }
}
