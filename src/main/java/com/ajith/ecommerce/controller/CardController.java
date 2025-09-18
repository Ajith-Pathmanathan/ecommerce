package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.CardDto;
import com.ajith.ecommerce.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
@Tag(
        name = "CRUD REST API for payment cards",
        description = "create , delete , update operation of payment card related details"
)

public class CardController {
    private final CardService cardService;

    @Operation(
            summary = "create payment card",
            description = "API for add new payment card"
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTp status created",
                    content = @Content(
                            schema = @Schema(implementation = CardDto.class)
                    )
            )
    )
    @PostMapping
    public CardDto saveCard(@RequestBody CardDto cardDto) {
        return cardService.saveCard(cardDto);
    }

    @Operation(
            summary = "delete card",
            description = "remove card from user's payment card list"
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status success",
                    content = @Content(mediaType = "text/plain"))
    )
    @DeleteMapping("/{id}")
    public String removeCard(@PathVariable(value = "id") UUID id) {
        return cardService.removeCard(id);

    }

    @Operation(
            summary = "GET payment card by User ID",
            description = "fetch users's card"
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status success",
                    content = @Content(
                            array = @ArraySchema(
                                    schema = @Schema(implementation = CardDto.class)
                            )
                    )
            )
    )
    @GetMapping("user/{id}")
    public List<CardDto> getCardsByUserId(@PathVariable(value = "id") UUID id) {
        return cardService.getCardsByUserId(id);
    }

    @Operation(
            summary = "Get payment card by Id",
            description = "rest api for fetch card details by id "
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status success",
                    content = @Content(
                            schema = @Schema(implementation = CardDto.class)
                    )
            )
    )
    @GetMapping("/{id")
    public CardDto getCardById(@PathVariable(value = "id") UUID id) {
        return cardService.getCardById(id);
    }

}
