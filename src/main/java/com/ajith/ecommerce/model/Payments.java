package com.ajith.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Payments {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private Double amount;
    private LocalDateTime paymentDate;
    private String transactionId;
    @OneToOne
    @JoinColumn(name = "card_id")
    private Card card;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders orders;
    @ManyToOne
    @JoinColumn(name = "payment_status_id")
    private  PaymentStatus paymentStatus;
}
