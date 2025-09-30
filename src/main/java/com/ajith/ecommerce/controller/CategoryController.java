package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.CategoryDto;
import com.ajith.ecommerce.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@Tag(
        name = "CRUD REST API for product categories",
        description = "create , delete , update operation of product category related details"
)
public class CategoryController {
    private final CategoryService categoryService;

    @Operation(
            summary = "create product category",
            description = "API for add new product category")
    @ApiResponse(
            responseCode = "201",
            description = "HTTp status created",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CategoryDto.class)
            )


    )
    @PostMapping
    public CategoryDto saveCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.saveCategory(categoryDto);
    }

    @Operation(
            summary = "update product category",
            description = "API for update product category")
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CategoryDto.class)
            ))

    @PutMapping("/{id}")
    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable UUID id) {
        return categoryService.updateCategory(categoryDto, id);
    }

    @Operation(
            summary = "delete product category",
            description = "API for delete product category")
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CategoryDto.class)
            ))

    @DeleteMapping("/{id}")
    public CategoryDto deleteCategory(@PathVariable UUID id) {
        return categoryService.deleteCategory(id);
    }

    @Operation(
            summary = "get all product category",
            description = "API for get all product category")
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CategoryDto.class)
            ))
    @GetMapping
    public List<CategoryDto> getAllCategory() {
        return categoryService.getAllCategory();
    }


}
