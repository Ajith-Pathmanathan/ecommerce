package com.ajith.ecommerce.repository;

import com.ajith.ecommerce.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Categories, UUID> {
}
