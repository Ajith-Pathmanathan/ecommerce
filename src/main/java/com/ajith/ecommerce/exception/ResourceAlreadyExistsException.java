package com.ajith.ecommerce.exception;

import java.util.List;
import java.util.UUID;

public class ResourceAlreadyExistsException extends ServiceException {
    public ResourceAlreadyExistsException(String message) {
        super(message, UUID.randomUUID().toString(), List.of("enter another value"), "409");
    }
}
