package com.ajith.ecommerce.mapper;

import com.ajith.ecommerce.dto.CategoryDto;
import com.ajith.ecommerce.model.Categories;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Categories categories);
    Categories ttoEntity(CategoryDto categoryDto);
}
