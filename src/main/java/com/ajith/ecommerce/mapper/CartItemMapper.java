package com.ajith.ecommerce.mapper;

import com.ajith.ecommerce.dto.CardItemDto;
import com.ajith.ecommerce.model.CartItems;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CartItemMapper {
    CartItems toEntity(CardItemDto cardItemDto);

    CardItemDto toDto(CartItems cartItems);

    List<CardItemDto> toListDto(List<CartItems> cartItems);
}
