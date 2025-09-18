package com.ajith.ecommerce.service;

import com.ajith.ecommerce.dto.PaymentDto;
import com.ajith.ecommerce.dto.PaymentHistoryDto;

import java.util.List;
import java.util.UUID;

public interface PaymentService {
    String savePayment(PaymentDto paymentDto);

    List<PaymentHistoryDto> getPaymentHistoryByUserId(UUID id);
}
