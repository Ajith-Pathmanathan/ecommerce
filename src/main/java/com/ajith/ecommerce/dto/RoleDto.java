package com.ajith.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class RoleDto {
    private UUID id;
    private String name;
    private String description;
}
