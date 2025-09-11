package com.ajith.ecommerce.repository;

import com.ajith.ecommerce.model.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CartItemRepository extends JpaRepository<CartItems, UUID> {
    List<CartItems> findByUsers_id(UUID id);
}
