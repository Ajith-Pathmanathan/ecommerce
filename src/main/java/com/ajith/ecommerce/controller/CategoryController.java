package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.CategoryDto;
import com.ajith.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public CategoryDto saveCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.saveCategory(categoryDto);
    }

    @PutMapping("/{id}")
    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable UUID id) {
        return categoryService.updateCategory(categoryDto, id);
    }

    @DeleteMapping("/{id}")
    public CategoryDto deleteCategory(@PathVariable UUID id) {
        return categoryService.deleteCategory(id);
    }

    @GetMapping
    public List<CategoryDto> getAllCategory() {
        return categoryService.getAllCategory();
    }


}
