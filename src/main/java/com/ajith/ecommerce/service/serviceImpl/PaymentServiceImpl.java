package com.ajith.ecommerce.service.serviceImpl;

import com.ajith.ecommerce.dto.PaymentDto;
import com.ajith.ecommerce.dto.PaymentHistoryDto;
import com.ajith.ecommerce.exception.ResourceNotFoundException;
import com.ajith.ecommerce.model.Card;
import com.ajith.ecommerce.model.Orders;
import com.ajith.ecommerce.model.Payments;
import com.ajith.ecommerce.repository.CardRepository;
import com.ajith.ecommerce.repository.OrderRepository;
import com.ajith.ecommerce.repository.PaymentRepository;
import com.ajith.ecommerce.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final OrderRepository orderRepository;
    private final CardRepository cardRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public String savePayment(PaymentDto paymentDto) {
        Orders orders = orderRepository.findById(paymentDto.getOrderId()).orElseThrow(() -> new ResourceNotFoundException("order not found with id : %s".formatted(paymentDto.getOrderId()), List.of("enter valid order id")));
        Card card = cardRepository.findById(paymentDto.getCardId()).orElseThrow(() -> new ResourceNotFoundException("card not found with Id %s : ".formatted(paymentDto.getCardId()), List.of("enter valid card id")));
        //here i have to add notification payment process related stuff
        Payments payments = Payments.builder()
                .amount(orders.getTotalAmount())
                .card(card)
                .transactionId(UUID.randomUUID().toString())
                .orders(orders)
                .build();
        paymentRepository.save(payments);

        return "payment success full";
    }

    @Override
    public List<PaymentHistoryDto> getPaymentHistoryByUserId(UUID id) {
         List<PaymentHistoryDto > paymentHistoryDtos = paymentRepository.getPaymentHistoryByUserId(id);
        return List.of();
    }

}
