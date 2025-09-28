package com.ajith.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class PaymentDto {
    private UUID id;
    private Double amount;
    private LocalDateTime paymentDate;
    private String transactionId;
    private UUID cardId;
    private UUID orderId;
    private UUID paymentStatusId;
}
