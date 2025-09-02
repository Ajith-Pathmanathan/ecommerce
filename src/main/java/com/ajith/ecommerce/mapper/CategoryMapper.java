package com.ajith.ecommerce.mapper;

import com.ajith.ecommerce.dto.CategoryDto;
import com.ajith.ecommerce.model.Categories;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Categories categories);
    Categories toEntity(CategoryDto categoryDto);
    List<CategoryDto> toDtoList(List<Categories> categoriesList);
}
