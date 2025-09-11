package com.ajith.ecommerce.service;

import com.ajith.ecommerce.dto.CardItemDto;

import java.util.List;
import java.util.UUID;

public interface CardItemService {
    CardItemDto createCardItem(CardItemDto cardItemDto);

    List<CardItemDto> getCardItemByUserId(UUID id);
}
