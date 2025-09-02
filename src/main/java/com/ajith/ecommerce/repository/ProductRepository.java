package com.ajith.ecommerce.repository;

import com.ajith.ecommerce.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Products, UUID> {
    @Query("""
             SELECT p FROM Products p
             JOIN p.category c
             WHERE (:categoryId IS NULL OR c.id = :categoryId )
             AND (:maxPrice IS NULL OR p.price<= :maxPrice)
             AND (:minPrice IS NULL OR p.price>= :minPrice)
             AND (:search IS NULL OR LOWER(p.name) LIKE LOWER (CONCAT('%', :search , '%')))
            """)
    List<Products> findProductsWithFilters(UUID categoryId, Double minPrice, Double maxPrice, String search);
}
