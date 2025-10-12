package com.ajith.ecommerce.dto;

import com.ajith.ecommerce.enums.CardType;
import com.ajith.ecommerce.valication.ValidDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class CardDto {
    private UUID id;
    @NotBlank(message = "Card number cannot be blank")
    @Length(min = 16, max = 16, message = "Card number must be 16 digits")
    private String cardNumber;
    @NotBlank(message = "Card holder name cannot be blank")
    @Length(min = 3, max = 20, message = "CVV must be 3 or 4 digits")
    private String cardHolderName;
    @NotBlank(message = "Expiry date cannot be blank")
    @ValidDate(monthsInFuture = 1, message = "Expiry date must be at least one month in the future")
    private LocalDateTime expiryDate;
    @NotBlank(message = "card type cannot be blank")
    @Pattern(regexp = "VISA|MASTERCARD|AMEX|DISCOVER", message = "Card type must be one of VISA, MASTERCARD, AMEX, DISCOVER")
    private CardType cardType;
    @NotBlank(message = "User ID cannot be blank")
    private UUID userId;
}
