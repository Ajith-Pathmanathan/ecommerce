package com.ajith.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class OrderDto {
    private UUID id;
    private Double totalAmount;
    private Integer count;
    private LocalDateTime orderDate;
    private UUID productId;
    private UUID orderStatusId;
    private UUID userId;
}