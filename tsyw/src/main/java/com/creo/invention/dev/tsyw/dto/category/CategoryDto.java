package com.creo.invention.dev.tsyw.dto.category;

import lombok.Data;

import java.util.UUID;

@Data
public class CategoryDto {
    private UUID categoryId;
    private String name;
}
