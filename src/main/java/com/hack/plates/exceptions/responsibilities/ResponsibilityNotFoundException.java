package com.hack.plates.exceptions.responsibilities;

public class ResponsibilityNotFoundException extends RuntimeException {

    public ResponsibilityNotFoundException(String message) {
        super(message);
    }

    public ResponsibilityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
