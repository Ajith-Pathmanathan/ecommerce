package com.ajith.ecommerce.dto;

import com.ajith.ecommerce.enums.CardType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class CardDto {
    private UUID id;

    private String cardNumber;

    private String cardHolderName;
    private LocalDateTime expiryDate;
    private LocalDateTime createdDate;
    private CardType cardType;
    private UUID userId;
}
