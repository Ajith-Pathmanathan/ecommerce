package com.ajith.ecommerce.service.serviceImpl;

import com.ajith.ecommerce.dto.PaymentDto;
import com.ajith.ecommerce.exception.ResourceNotFoundException;
import com.ajith.ecommerce.model.Card;
import com.ajith.ecommerce.model.Orders;
import com.ajith.ecommerce.model.Payments;
import com.ajith.ecommerce.repository.CardRepository;
import com.ajith.ecommerce.repository.OrderRepository;
import com.ajith.ecommerce.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatmentServiceImpl implements PaymentService {
    private final OrderRepository orderRepository;
    private final CardRepository cardRepository;
    @Override
    public String savePayment(PaymentDto paymentDto) {
        List<Orders> orders = orderRepository.findByIdIn(paymentDto.getOrderIds());
        Double totalAmount = orders.stream().map(Orders::getTotalAmount).reduce(0.0,Double::sum);
        Card card = cardRepository.findById(paymentDto.getCardId()).orElseThrow(()->new ResourceNotFoundException("card not found with Id %s : ".formatted(paymentDto.getCardId())));
        Payments payments = Payments.builder()
                .amount(totalAmount)
                .card(card)
                .transactionId(UUID.randomUUID().toString())
                .orders(orders)
                .build();
        return null;
    }
}
