package com.ajith.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CardItemDto {
    private UUID id;
    @NotBlank(message = "userId should not be null")
    private UUID userId;
    @NotBlank(message = "productId should not be null")
    private UUID productId;
    @NotBlank(message = "count should not be null")
    private Integer count;
}
