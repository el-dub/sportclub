package com.creo.invention.dev.tsyw.dto.usersubscription;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class CreateUserSubscriptionDto {
    // UUID userId;
    UUID subscriptionId;
    LocalDate startDate;
    Boolean paid = false;
}
