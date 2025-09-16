package com.ajith.ecommerce.dto;

import com.ajith.ecommerce.model.Card;
import com.ajith.ecommerce.model.Orders;
import com.ajith.ecommerce.model.PaymentStatus;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Data
@Builder
public class PaymentDto {
    private UUID id;
    private Double amount;
    private LocalDateTime paymentDate;
    private String transactionId;
    private UUID cardId;
    private List<UUID> orderIds;
    private UUID paymentStatusId;
}
