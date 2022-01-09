package com.creo.invention.dev.tsyw.dto.usersubscription;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UpdateUserSubscriptionDto {

    private UUID id;
    private LocalDateTime endTime;
    private Integer visitsNumber;

}
