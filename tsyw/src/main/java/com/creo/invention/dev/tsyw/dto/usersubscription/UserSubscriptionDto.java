package com.creo.invention.dev.tsyw.dto.usersubscription;

import com.creo.invention.dev.tsyw.model.Subscription;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserSubscriptionDto {
    private UUID id;
    private UUID userId;
    private Subscription subscription;
    private Boolean paid = false;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer visitsNumber;
}
