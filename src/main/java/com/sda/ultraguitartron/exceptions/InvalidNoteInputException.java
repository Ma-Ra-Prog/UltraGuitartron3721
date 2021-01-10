package com.sda.ultraguitartron.exceptions;

import java.util.List;
import java.util.stream.Collectors;

public class InvalidNoteInputException extends IllegalArgumentException {

    private List<String> errors;

    public void addErrorMessage(String error) {
        errors.add(error);
    }

    public InvalidNoteInputException(String message) {
        super("INVALID ARGUMENT: " + message);
    }

    @Override
    public String getMessage() {
        return errors.stream().collect(Collectors.joining("\n"));
    }
}