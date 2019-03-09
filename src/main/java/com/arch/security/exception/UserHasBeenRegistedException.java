package com.arch.security.exception;

public class UserHasBeenRegistedException extends RuntimeException {

    public UserHasBeenRegistedException(String message) {
        super(message);
    }

}
