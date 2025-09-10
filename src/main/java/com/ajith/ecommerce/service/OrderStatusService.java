package com.ajith.ecommerce.service;

import com.ajith.ecommerce.dto.OrderStatusDto;

import java.util.List;

public interface OrderStatusService {
    OrderStatusDto saveOrderStatus(OrderStatusDto orderStatusDto);

    List<OrderStatusDto> getAllOrderStatus();
}
