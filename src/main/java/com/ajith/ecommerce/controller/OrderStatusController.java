package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.OrderStatusDto;
import com.ajith.ecommerce.service.OrderStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-status")
@RequiredArgsConstructor
public class OrderStatusController {
    private final OrderStatusService orderStatusService;
    @PostMapping
    public OrderStatusDto saveOrderStatus(@RequestBody OrderStatusDto orderStatusDto){
                return orderStatusService.saveOrderStatus(orderStatusDto);
    }
    @GetMapping
    public List<OrderStatusDto> getAllOrderStatus(){
        return orderStatusService.getAllOrderStatus();
    }
}
