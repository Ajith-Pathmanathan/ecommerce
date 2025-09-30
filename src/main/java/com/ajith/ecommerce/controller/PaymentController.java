package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.PaymentDto;
import com.ajith.ecommerce.dto.PaymentHistoryDto;
import com.ajith.ecommerce.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
@Tag(
        name = "payment related apis",
        description = "api for payment processing and payment history"
)
public class PaymentController {
    private final PaymentService paymentService;

    @Operation(
            summary = "process payment",
            description = "API to process a payment"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status success",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = String.class)
            ))
    @PostMapping
    public String savePayment(PaymentDto paymentDto) {
        return paymentService.savePayment(paymentDto);
    }

    @Operation(
            summary = "get payment history by user id",
            description = "API to get payment history for a specific user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status success",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(
                            schema = @Schema(implementation = PaymentHistoryDto.class)
                    )
            ))
    @PostMapping("/user/{id}")
    public List<PaymentHistoryDto> getPaymentHistoryByUserId(@PathVariable(value = "id") UUID id) {
        return paymentService.getPaymentHistoryByUserId(id);
    }
}
