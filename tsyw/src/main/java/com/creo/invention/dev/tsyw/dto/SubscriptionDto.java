package com.creo.invention.dev.tsyw.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class SubscriptionDto {

    private UUID subscriptionId;
    private String name;
    private CategoryDto category;
    private Integer monthsDuration;
    private BigDecimal price;
    private Integer visitsNumber;
}
