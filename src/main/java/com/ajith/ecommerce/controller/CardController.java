package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.CardDto;
import com.ajith.ecommerce.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;
    @PostMapping
    public CardDto saveCard(@RequestBody CardDto cardDto){
        return cardService.aveCard(cardDto)

    }

}
