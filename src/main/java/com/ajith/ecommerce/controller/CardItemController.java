package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.CardItemDto;
import com.ajith.ecommerce.service.CardItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/card-items")
@Tag(
        name = "shopping card related apis",
        description = "api for add remove items in shopping card"
)
@RequiredArgsConstructor

public class CardItemController {
    private final CardItemService cardItemService;

    @Operation(
            summary = "add item to shopping cart",
            description = "create card Item "
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status created",
            content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CardItemDto.class)
            )
            }
    )
    @PostMapping
    public CardItemDto createCardItem(CardItemDto cardItemDto) {
        return cardItemService.createCardItem(cardItemDto);
    }

    @Operation(
            summary = "remove item from shopping cart",
            description = "delete card Item "

    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status success",
            content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CardItemDto.class)
            )
            }
    )
    @GetMapping("/user/{id}")
    public List<CardItemDto> getCardItemByUserId(@PathVariable(value = "id") UUID id) {
        return cardItemService.getCardItemByUserId(id);
    }

    @Operation(
            summary = "get item from shopping cart",
            description = "get card Item by id "
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status success",
            content = {@Content(
                    mediaType = "application/json",
                    array = @ArraySchema(
                            schema = @Schema(implementation = CardItemDto.class)
                    )
            )
            }
    )
    @GetMapping("/{id}")
    public CardItemDto getCardItem(@RequestParam(value = "id") UUID id) {
        return cardItemService.getCardItem(id);
    }
}
