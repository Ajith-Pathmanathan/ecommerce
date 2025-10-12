package com.ajith.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class PaymentStatus {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    @OneToMany(mappedBy = "paymentStatus")
    private List<Payments> payments;
}
