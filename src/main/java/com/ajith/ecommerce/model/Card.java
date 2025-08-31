package com.ajith.ecommerce.model;

import com.ajith.ecommerce.enums.CardType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Card {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String cardNumber;
    private String cardHolderName;
    private LocalDateTime expiryDate;
    private LocalDateTime createdDate;
    @Enumerated(EnumType.STRING)
    private CardType cardType;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;
}

