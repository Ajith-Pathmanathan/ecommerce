package com.ajith.ecommerce.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CardItemDto {
    private UUID id;
    private String cardNumber;
    private String cardHolderName;
    private LocalDateTime expiryDate;
    private LocalDateTime createdDate;
    private UUID userId;
    private UUID productId;
}
