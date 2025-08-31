package com.ajith.ecommerce.model;

import jakarta.persistence.*;
import jdk.jshell.Snippet;
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
public class Orders {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private Double totalAmount;
    private Integer count;
    private LocalDateTime orderDate;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products products;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private OrderStatus orderStatus;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
}
