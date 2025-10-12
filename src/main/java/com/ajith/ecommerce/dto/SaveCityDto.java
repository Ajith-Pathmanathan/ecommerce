package com.ajith.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class SaveCityDto {
    @NotBlank(message = "city name should not be null")
    private String name;
    @NotBlank(message = "countryId should not be null")
    private UUID countryId;
}
