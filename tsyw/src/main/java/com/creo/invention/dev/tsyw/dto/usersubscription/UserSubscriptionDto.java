package com.creo.invention.dev.tsyw.dto.usersubscription;

import com.creo.invention.dev.tsyw.dto.subscription.SubscriptionDto;
import com.creo.invention.dev.tsyw.model.Subscription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserSubscriptionDto {
    private UUID id;
    private UUID userId;
    private SubscriptionDto subscription;
    private Boolean paid = false;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer visitsNumber;
}
