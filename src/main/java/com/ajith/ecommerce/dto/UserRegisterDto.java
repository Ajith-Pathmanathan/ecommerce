package com.ajith.ecommerce.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserRegisterDto {
    private UUID id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private String address;
    private UUID countryId;
    private UUID cityId;
}
