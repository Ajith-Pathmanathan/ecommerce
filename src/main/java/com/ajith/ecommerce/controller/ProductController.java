package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.ProductDto;
import com.ajith.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@Tag(
        name = "CRUD REST API for products",
        description = "create , delete , update operation of product related details"
)
public class ProductController {
    private final ProductService productService;

    @Operation(
            summary = "create product",
            description = "API for add new product")
    @ApiResponse(
            responseCode = "201",
            description = "HTTp status created",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ProductDto.class)
            )
    )
    @PostMapping
    public ProductDto saveProduct(@RequestBody @Validated ProductDto productDto) {
        return productService.saveProduct(productDto);
    }

    @Operation(
            summary = "update product",
            description = "API for update product")
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ProductDto.class)
            )
    )
    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable("id") UUID id, @RequestBody ProductDto productDto) {
        return productService.updateProduct(id, productDto);
    }

    @Operation(
            summary = "delete product",
            description = "API for delete product")
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ProductDto.class)
            ))
    @DeleteMapping("/{id}")
    public ProductDto deleteProduct(@PathVariable("id") UUID id) {
        return productService.deleteProduct(id);
    }

    @Operation(
            summary = "get product by id",
            description = "API to get product by id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ProductDto.class)
            ))
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable("id") UUID id) {
        return productService.getProductById(id);
    }

    @Operation(
            summary = "get filtered products",
            description = "API to get filtered products by category id, min price, max price and search keyword"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(
                            schema = @Schema(implementation = ProductDto.class
                            )
                    )))

    @GetMapping
    public List<ProductDto> getFilteredProducts(@RequestParam UUID categoryId, @RequestParam Double minPrice, @RequestParam Double maxPrice, @RequestParam String search) {
        return productService.getFilteredProducts(categoryId, minPrice, maxPrice, search);
    }


}
