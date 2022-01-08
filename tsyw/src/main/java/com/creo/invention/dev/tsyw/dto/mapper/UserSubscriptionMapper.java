package com.creo.invention.dev.tsyw.dto.mapper;

import com.creo.invention.dev.tsyw.dto.usersubscription.UserSubscriptionDto;
import com.creo.invention.dev.tsyw.model.UserSubscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SubscriptionMapper.class})
public interface UserSubscriptionMapper {

    @Mapping(source = "user.userId", target = "userId")
    UserSubscriptionDto toDto(UserSubscription userSubscription);

    List<UserSubscriptionDto> toDtoList(List<UserSubscription> userSubscriptions);
}
