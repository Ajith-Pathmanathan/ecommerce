package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.OrderDto;
import com.ajith.ecommerce.service.OrderService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public OrderDto saveOrder(@RequestBody OrderDto orderDto) {
        return orderService.saveOrder(orderDto);
    }
    @PutMapping("/{id}")
    public OrderDto updateOrder(@PathVariable("id") UUID id, @RequestBody OrderDto orderDto){
        return orderService.updateOrder(id,orderDto);
    }
    @DeleteMapping("/{id}")
    public OrderDto deleteOrder(@PathVariable("id") UUID id){
        return orderService.deleteOrder(id);
    }
}
