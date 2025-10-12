package com.ajith.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class OrderDto {
    private UUID id;
    @NotBlank(message = "Total amount should not be null")
    @Positive(message = "Total amount should be positive")
    private Double totalAmount;
    @Positive(message = "Count should be positive")
    private Integer count;
    private LocalDateTime orderDate;
    @NotBlank(message = "Pro should not be null")
    private UUID productId;
    @NotBlank(message = "Address should not be null")
    private UUID orderStatusId;
    @NotBlank(message = "User should not be null")
    private UUID userId;
}