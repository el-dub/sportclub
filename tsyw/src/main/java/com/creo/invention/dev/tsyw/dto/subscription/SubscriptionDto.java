package com.creo.invention.dev.tsyw.dto.subscription;

import com.creo.invention.dev.tsyw.dto.CategoryDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class SubscriptionDto {

    private UUID subscriptionId;
    private CategoryDto category;
    private Integer monthsDuration;
    private BigDecimal price;
    private Integer visitsNumber;
}
