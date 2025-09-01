package com.ajith.ecommerce.repository;

import com.ajith.ecommerce.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Products, UUID> {
}
