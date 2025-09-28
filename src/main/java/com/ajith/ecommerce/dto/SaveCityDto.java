package com.ajith.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class SaveCityDto {
    private String name;
    private UUID countryId;
}
