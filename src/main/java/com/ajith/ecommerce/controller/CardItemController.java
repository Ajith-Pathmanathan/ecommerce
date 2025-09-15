package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.CardItemDto;
import com.ajith.ecommerce.service.CardItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card-items")
public class CardItemController {
    private final CardItemService cardItemService;

    @PostMapping
    public CardItemDto createCardItem(CardItemDto cardItemDto) {
        return cardItemService.createCardItem(cardItemDto);
    }

    @GetMapping("/user/{id}")
    public List<CardItemDto> getCardItemByUserId(@PathVariable(value = "id") UUID id) {
        return cardItemService.getCardItemByUserId(id);
    }
    @GetMapping("/{id}")
    public CardItemDto getCardItem(@RequestParam(value = "id") UUID id){
        return cardItemService.getCardItem(id);
    }
}
