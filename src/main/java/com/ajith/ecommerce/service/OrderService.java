package com.ajith.ecommerce.service;

import com.ajith.ecommerce.dto.OrderDto;

import java.util.UUID;

public interface OrderService {
    OrderDto saveOrder(OrderDto orderDto);

    OrderDto updateOrder(UUID id, OrderDto orderDto);

    OrderDto deleteOrder(UUID id);
}
