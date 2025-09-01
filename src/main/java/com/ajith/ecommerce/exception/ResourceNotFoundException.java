package com.ajith.ecommerce.exception;

import java.util.List;
import java.util.UUID;

public class ResourceNotFoundException extends ServiceException {
    public ResourceNotFoundException(String message, List<String> suggestion) {

        super(message, UUID.randomUUID().toString(), suggestion, "404");
    }
}
