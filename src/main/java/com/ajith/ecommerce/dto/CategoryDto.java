package com.ajith.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class CategoryDto {

    private UUID id;
    @NotBlank(message = "category name should not be null")
    private String name;
    @NotBlank(message = "description should not be blank")
    private String description;
}
