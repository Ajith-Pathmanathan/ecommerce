package com.ajith.ecommerce.service;

import com.ajith.ecommerce.dto.CardDto;

import java.util.List;
import java.util.UUID;

public interface CardService {
    CardDto saveCard(CardDto cardDto);

    String removeCard(UUID id);

    List<CardDto> getCardsByUserId(UUID id);

    CardDto getCardById(UUID id);
}
