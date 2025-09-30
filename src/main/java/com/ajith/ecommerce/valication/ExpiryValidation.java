package com.ajith.ecommerce.valication;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

public class ExpiryValidation implements ConstraintValidator<ValidDate, LocalDateTime> {
    private int monthsInFuture = 1;
    @Override
    public void initialize(ValidDate constraintAnnotation) {
        this.monthsInFuture = constraintAnnotation.monthsInFuture();
    }
    @Override
    public boolean isValid(LocalDateTime dateTime, ConstraintValidatorContext constraintValidatorContext) {
        return dateTime != null && dateTime.isAfter(LocalDateTime.now().plusMonths(monthsInFuture));
    }


}
