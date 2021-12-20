package com.creo.invention.dev.tsyw.dto.subscription;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class UpdateSubscriptionDto {

    private UUID subscriptionId;
    private UUID categoryId;
    private Integer monthsDuration;
    private BigDecimal price;
    private Integer visitsNumber;
}
