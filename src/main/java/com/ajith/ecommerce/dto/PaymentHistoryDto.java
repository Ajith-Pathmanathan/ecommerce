package com.ajith.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class PaymentHistoryDto {

    private String email;
    private String mobileNum;
    private String amount;
    private String paymentStatus;
    private ProductDto productDto;
    private UUID id;
    private String productName;
    private Double productPrice;
    private String description;
    private String imageUrl;
}
