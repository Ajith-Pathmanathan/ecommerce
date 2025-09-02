package com.ajith.ecommerce.service;

import com.ajith.ecommerce.dto.CategoryDto;

import java.util.List;
import java.util.UUID;

public interface CategoryService {


    CategoryDto saveCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, UUID id);

    CategoryDto deleteCategory(UUID id);

    List<CategoryDto> getAllCategory();
}
