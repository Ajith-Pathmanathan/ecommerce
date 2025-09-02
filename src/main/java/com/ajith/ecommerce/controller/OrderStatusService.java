package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.OrderStatusDto;

import java.util.List;

public interface OrderStatusService {
    OrderStatusDto saveOrderStatus(OrderStatusDto orderStatusDto);

    List<OrderStatusDto> getAllOrderStatus();
}
