package com.udacity.pricing.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Price not found")
public class PriceNotFountException extends RuntimeException {

    public PriceNotFountException(){}

    public PriceNotFountException(String message) {
        super(message);
    }
}
