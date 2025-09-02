package com.ajith.ecommerce.service.serviceImpl;

import com.ajith.ecommerce.dto.ProductDto;
import com.ajith.ecommerce.exception.ResourceNotFoundException;
import com.ajith.ecommerce.mapper.ProductMapper;
import com.ajith.ecommerce.model.Categories;
import com.ajith.ecommerce.model.Products;
import com.ajith.ecommerce.repository.CategoryRepository;
import com.ajith.ecommerce.repository.ProductRepository;
import com.ajith.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Categories categories = categoryRepository.findById(productDto.getCategories().getId()).orElseThrow(() -> new ResourceNotFoundException("category not found", List.of("enter correct Category id")));
        Products products = productMapper.toProduct(productDto);
        products.setCategories(categories);
        productRepository.save(products);
        return productMapper.toProductDto(products);
    }

    @Override
    public ProductDto updateProduct(UUID id, ProductDto productDto) {
        Products products = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("product not found with id: %S", id), List.of("enter correct ProductId")));
        Categories categories = categoryRepository.findById(productDto.getCategories().getId()).orElseThrow(() -> new ResourceNotFoundException(String.format("category noy found with id : %s", productDto.getCategories().getId()), List.of("enter correct category id")));
        productDto.setId(products.getId());
        Products updatedProducts = productMapper.toProduct(productDto);
        updatedProducts.setCategories(categories);
        productRepository.save(updatedProducts);
        return productMapper.toProductDto(updatedProducts);
    }

    @Override
    public ProductDto deleteProduct(UUID id) {
        Products products = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("product not found with id : %s", id), List.of("enter valid product id")));
        productRepository.deleteById(id);
        return productMapper.toProductDto(products);
    }

    @Override
    public ProductDto getProductById(UUID id) {
        Products products = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("product not found with id : %s", id), List.of("enter valid product id")));
        return productMapper.toProductDto(products);
    }

    @Override
    public List<ProductDto> getFilteredProducts(UUID categoryId, Double minPrice, Double maxPrice, String search) {

        return List.of();
    }


}
