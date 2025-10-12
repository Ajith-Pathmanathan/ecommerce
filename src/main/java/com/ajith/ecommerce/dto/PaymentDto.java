package com.ajith.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class PaymentDto {
    private UUID id;
    @Positive(message = "Amount should be positive")
    private Double amount;
    private String transactionId;
    @NotBlank(message = "Payment date should not be null")
    private UUID cardId;
    @NotBlank(message = "Order should not be null")
    private UUID orderId;
    @NotBlank (message = "Payment status should not be null")
    private UUID paymentStatusId;
}
