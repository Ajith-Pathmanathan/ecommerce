package com.ajith.ecommerce.dto;

import com.ajith.ecommerce.enums.CardType;
import com.ajith.ecommerce.valication.ValidDate;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class CardDto {
    private UUID id;
    @Length (min = 16, max = 16, message = "Card number must be 16 digits")
    private String cardNumber;
    @Length(min = 3, max = 20, message = "CVV must be 3 or 4 digits")
    private String cardHolderName;
    @NotNull
    @ValidDate(monthsInFuture = 1, message = "Expiry date must be at least one month in the future")
    private LocalDateTime expiryDate;
    private CardType cardType;
    private UUID userId;
}
