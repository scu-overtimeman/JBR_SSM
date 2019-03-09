package com.jbr.backend.exception;

public class UserHasBeenRegistedException extends RuntimeException {

    public UserHasBeenRegistedException(String message) {
        super(message);
    }

}
