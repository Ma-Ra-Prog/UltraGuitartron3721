package com.sda.ultraguitartron.exceptions;

public class InvalidNoteInputException extends IllegalArgumentException {
    public InvalidNoteInputException(String message) {
        super("INVALID ARGUMENT: " + message);
    }
}
