package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.ProductDto;
import com.ajith.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductDto saveProduct(@RequestBody @Validated ProductDto productDto) {
        return productService.saveProduct(productDto);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable("id") UUID id, @RequestBody ProductDto productDto) {
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("/{id}")
    public ProductDto deleteProduct(@PathVariable("id") UUID id) {
        return productService.deleteProduct(id);
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable("id") UUID id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<ProductDto> getFilteredProducts(@RequestParam UUID categoryId, @RequestParam Double minPrice, @RequestParam Double maxPrice, @RequestParam String search) {
        return productService.getFilteredProducts(categoryId, minPrice, maxPrice, search);
    }


}
