package com.test.iris.payment_service.exception;

public class InvalidCardException extends RuntimeException  {
    public InvalidCardException(String message) {
        super(message);
    }
}
