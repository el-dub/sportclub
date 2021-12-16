package com.creo.invention.dev.tsyw.service;

import com.creo.invention.dev.tsyw.dto.SubscriptionDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SubscriptionService {

    List<SubscriptionDto> getAll();
}
