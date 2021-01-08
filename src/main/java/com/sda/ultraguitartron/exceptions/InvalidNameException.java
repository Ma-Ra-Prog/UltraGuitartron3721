package com.sda.ultraguitartron.exceptions;

public class InvalidNameException extends IllegalArgumentException {
    public InvalidNameException(String message) {
        super("INVALID ARGUMENT: " + message);
    }
}
