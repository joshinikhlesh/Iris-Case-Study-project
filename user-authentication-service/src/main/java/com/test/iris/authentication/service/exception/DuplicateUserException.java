package com.test.iris.authentication.service.exception;

public class DuplicateUserException
        extends RuntimeException {

    public DuplicateUserException(String message) {
        super(message);
    }
}
