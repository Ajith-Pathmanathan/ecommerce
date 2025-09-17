package com.ajith.ecommerce.service;

import com.ajith.ecommerce.dto.PaymentDto;

public interface PaymentService {
    String savePayment(PaymentDto paymentDto);
}
