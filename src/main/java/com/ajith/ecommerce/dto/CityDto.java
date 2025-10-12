package com.ajith.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CityDto {
    private UUID id;
    @NotBlank(message = "City name should not be blank")
    private String name;
}
