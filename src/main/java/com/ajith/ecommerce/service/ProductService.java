package com.ajith.ecommerce.service;

import com.ajith.ecommerce.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductDto saveProduct(ProductDto productDto);

    ProductDto updateProduct(UUID id, ProductDto productDto);

    ProductDto deleteProduct(UUID id);

    ProductDto getProductById(UUID id);


    List<ProductDto> getFilteredProducts(UUID categoryId, Double minPrice, Double maxPrice, String search);
}
