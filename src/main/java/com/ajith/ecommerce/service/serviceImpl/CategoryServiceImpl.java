package com.ajith.ecommerce.service.serviceImpl;

import com.ajith.ecommerce.dto.CategoryDto;
import com.ajith.ecommerce.exception.ResourceNotFoundException;
import com.ajith.ecommerce.mapper.CategoryMapper;
import com.ajith.ecommerce.model.Categories;
import com.ajith.ecommerce.repository.CategoryRepository;
import com.ajith.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Categories categories = categoryMapper.toEntity(categoryDto);
        return categoryMapper.toDto(categoryRepository.save(categories));
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, UUID id) {
        categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("category not found with id : %s", id), List.of("enter correct category Id")));
        Categories categories = categoryMapper.toEntity(categoryDto);
        categories.setId(id);
        return categoryMapper.toDto(categoryRepository.save(categories));
    }

    @Override
    public CategoryDto deleteCategory(UUID id) {
        Categories categories = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("category not found with id : %s", id), List.of("enter correct category Id")));
        categoryRepository.deleteById(id);
        return categoryMapper.toDto(categories);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Categories> categoriesList = categoryRepository.findAll();
        return categoryMapper.toDtoList(categoriesList);
    }
}
