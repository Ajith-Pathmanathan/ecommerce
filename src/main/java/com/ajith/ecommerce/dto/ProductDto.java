package com.ajith.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ProductDto {
    private UUID id;
    @NotBlank(message = " product name should not be blank")
    private String name;
    @NotNull(message = "product price should not be null")
    private Double price;
    @NotBlank(message = "product description should not be blank")
    private String description;
    @NotBlank(message = "image url should not be blank")
    private String imageUrl;
    @Positive(message = "stock quantity should be positive")
    private Integer stockQuantity;
    private LocalDateTime createdAt;
    private CategoryDto  categories;
}
