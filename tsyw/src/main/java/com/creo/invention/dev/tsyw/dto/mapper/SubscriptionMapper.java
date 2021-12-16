package com.creo.invention.dev.tsyw.dto.mapper;

import com.creo.invention.dev.tsyw.dto.SubscriptionDto;
import com.creo.invention.dev.tsyw.model.Subscription;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionDto toDto(Subscription subscription);

    List<SubscriptionDto> toDtoList(List<Subscription> subscriptions);
}
