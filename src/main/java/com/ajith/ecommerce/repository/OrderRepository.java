package com.ajith.ecommerce.repository;

import com.ajith.ecommerce.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Orders, UUID> {
    List<Orders> findByIdIn(List<UUID> orderIds);
}
