package com.ajith.ecommerce.service.serviceImpl;

import com.ajith.ecommerce.dto.OrderDto;
import com.ajith.ecommerce.exception.ResourceNotFoundException;
import com.ajith.ecommerce.mapper.OrderMapper;
import com.ajith.ecommerce.model.Orders;
import com.ajith.ecommerce.model.Products;
import com.ajith.ecommerce.model.Users;
import com.ajith.ecommerce.repository.OrderRepository;
import com.ajith.ecommerce.repository.ProductRepository;
import com.ajith.ecommerce.repository.UserRepository;
import com.ajith.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        Products products = productRepository.findById(orderDto.getProductId()).orElseThrow(() -> new ResourceNotFoundException(String.format("product Not found with id :%s", orderDto.getProductId()), List.of("enter valied product id")));
        Users users = userRepository.findById(orderDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException(String.format("User Not found with id :%s", orderDto.getProductId()), List.of("enter valied user id")));
        Orders orders = orderMapper.toEntity(orderDto);
        orders.setUsers(users);
        orders.setProducts(products);
        orders = orderRepository.save(orders);
        return orderMapper.toDto(orders);
    }

    @Override
    public OrderDto updateOrder(UUID id, OrderDto orderDto) {
        orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Order Not found with id :%s", orderDto.getId()), List.of("enter valied Order id")));
        Products products = productRepository.findById(orderDto.getProductId()).orElseThrow(() -> new ResourceNotFoundException(String.format("product Not found with id :%s", orderDto.getProductId()), List.of("enter valied product id")));
        Users users = userRepository.findById(orderDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException(String.format("User Not found with id :%s", orderDto.getProductId()), List.of("enter valied user id")));
        Orders orders = orderMapper.toEntity(orderDto);
        orders.setUsers(users);
        orders.setProducts(products);
        orders.setId(id);
        orders = orderRepository.save(orders);
        return orderMapper.toDto(orders);

    }

    @Override
    public OrderDto deleteOrder(UUID id) {
        Orders orders = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Order Not found with id :%s", id), List.of("enter valied Order id")));
        orderRepository.deleteById(id);
        return orderMapper.toDto(orders);
    }
}
