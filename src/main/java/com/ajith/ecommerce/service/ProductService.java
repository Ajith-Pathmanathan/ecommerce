package com.ajith.ecommerce.service;

import com.ajith.ecommerce.dto.ProductDto;

import java.util.UUID;

public interface ProductService {
    ProductDto saveProduct(ProductDto productDto);

    ProductDto updateProduct(UUID id, ProductDto productDto);
}
