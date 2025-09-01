package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.ProductDto;
import com.ajith.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
     @PostMapping
    public ProductDto saveProduct(@RequestBody @Validated ProductDto productDto){
         return productService.saveProduct(productDto);
     }
     @PutMapping("/{id}")
    public ProductDto updateProduct(@RequestParam("id") UUID id, @RequestBody ProductDto productDto){
         return productService.updateProduct(id,productDto);
     }


}
