package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.PaymentDto;
import com.ajith.ecommerce.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    @PostMapping
    public String savePayment(PaymentDto paymentDto){
     return  paymentService.savePayment(paymentDto);
    }
}
