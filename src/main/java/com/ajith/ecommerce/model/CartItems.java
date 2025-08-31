package com.ajith.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CartItems {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
//    private ShoppingCart cart;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Products  products;
    private Integer count;
}
