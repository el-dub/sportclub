package com.creo.invention.dev.tsyw.dto;

import com.creo.invention.dev.tsyw.model.Subscription;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Data
public class CategoryDto {

    private UUID categoryId;
    private String name;
}
