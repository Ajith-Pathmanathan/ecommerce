package com.ajith.ecommerce.mapper;

import com.ajith.ecommerce.dto.ProductDto;
import com.ajith.ecommerce.model.Products;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    Products toProduct(ProductDto productDto);

    ProductDto toProductDto(Products products);

}
