package com.ajith.ecommerce.service.serviceImpl;

import com.ajith.ecommerce.service.OrderStatusService;
import com.ajith.ecommerce.dto.OrderStatusDto;
import com.ajith.ecommerce.model.OrderStatus;
import com.ajith.ecommerce.repository.OrderStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderStatusServiceImpl implements OrderStatusService {
    private final OrderStatusRepository orderStatusRepository;

    @Override
    public OrderStatusDto saveOrderStatus(OrderStatusDto orderStatusDto) {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setName(orderStatus.getName());
        orderStatus = orderStatusRepository.save(orderStatus);
        return OrderStatusDto.builder()
                .id(orderStatus.getId())
                .name(orderStatus.getName())
                .build();
    }

    @Override
    public List<OrderStatusDto> getAllOrderStatus() {
        List<OrderStatus> orderStatusList = orderStatusRepository.findAll();
        return orderStatusList.stream().map(orderStatus ->
                OrderStatusDto.builder()
                        .name(orderStatus.getName())
                        .id(orderStatus.getId()).build()).toList();
    }
}
