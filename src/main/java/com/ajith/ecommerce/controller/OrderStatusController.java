package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.OrderStatusDto;
import com.ajith.ecommerce.service.OrderStatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-status")
@RequiredArgsConstructor
@Tag(
        name = "CRUD REST API for order status",
        description = "create , delete , update operation of order status related details"
)
public class OrderStatusController {
    private final OrderStatusService orderStatusService;

    @Operation(
            summary = "create order status",
            description = "API for add new order status"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTp status created",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = OrderStatusDto.class)
            )
    )
    @PostMapping
    public OrderStatusDto saveOrderStatus(@RequestBody OrderStatusDto orderStatusDto) {
        return orderStatusService.saveOrderStatus(orderStatusDto);
    }

    @Operation(
            summary = "get all order status",
            description = "API to get all order status"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = OrderStatusDto.class)
            )
    )
    @GetMapping
    public List<OrderStatusDto> getAllOrderStatus() {
        return orderStatusService.getAllOrderStatus();
    }
}
