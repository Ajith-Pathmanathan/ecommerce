package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.CardDto;
import com.ajith.ecommerce.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;

    @PostMapping
    public CardDto saveCard(@RequestBody CardDto cardDto) {
        return cardService.saveCard(cardDto);
    }

    @DeleteMapping("/id")
    public String removeCard(@PathVariable(value = "id") UUID id) {
        return cardService.removeCard(id);

    }

    @GetMapping("user/{id}")
    public List<CardDto> getCardsByUserId(@PathVariable(value = "id") UUID id) {
        return cardService.getCardsByUserId(id);
    }

    @GetMapping("/{id")
    public CardDto getCardById(@PathVariable(value = "id") UUID id) {
        return cardService.getCardById(id);
    }

}
