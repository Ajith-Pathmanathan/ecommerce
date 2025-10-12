package com.ajith.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class RoleDto {
    private UUID id;
    @NotBlank(message = "Role name should not be blank")
    private String name;
    @NotBlank(message = "Role description should not be blank")
    private String description;
}
