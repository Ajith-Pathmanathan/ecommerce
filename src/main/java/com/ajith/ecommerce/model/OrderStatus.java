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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class OrderStatus {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    @OneToMany(mappedBy = "orderStatus")
    private List<Orders> orders;

}
