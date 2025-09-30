package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.OrderDto;
import com.ajith.ecommerce.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
@Tag(
        name = "CRUD REST API for orders",
        description = "create , delete , update operation of order related details"
)
public class OrderController {
    private final OrderService orderService;

    @Operation(
            summary = "create order",
            description = "API for add new order"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTp status created",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = OrderDto.class)
            )
    )
    @PostMapping
    public OrderDto saveOrder(@RequestBody OrderDto orderDto) {
        return orderService.saveOrder(orderDto);
    }

    @Operation(
            summary = "update order",
            description = "API for update order"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = OrderDto.class)
            ))
    @PutMapping("/{id}")
    public OrderDto updateOrder(@PathVariable("id") UUID id, @RequestBody OrderDto orderDto) {
        return orderService.updateOrder(id, orderDto);
    }

    @Operation(
            summary = "delete order",
            description = "API for delete order"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = OrderDto.class)
            ))

    @DeleteMapping("/{id}")
    public OrderDto deleteOrder(@PathVariable("id") UUID id) {
        return orderService.deleteOrder(id);
    }
}
