package com.ajith.ecommerce.dto;

import com.ajith.ecommerce.enums.CardType;
import com.ajith.ecommerce.model.Users;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
