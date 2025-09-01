package com.ajith.ecommerce.exception;

import lombok.Getter;

import java.util.List;
@Getter
public class ServiceException extends RuntimeException {
    private final String uuid;
    private final List<String> suggestions;
    private final String errorCode;

    public ServiceException(String message, String uuid, List<String> suggestions, String errorCode) {
        super(message);
        this.errorCode = errorCode;
        this.uuid = uuid;
        this.suggestions = suggestions;
    }
}
