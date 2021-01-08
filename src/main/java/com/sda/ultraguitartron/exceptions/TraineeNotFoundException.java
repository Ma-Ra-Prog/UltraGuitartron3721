package com.sda.ultraguitartron.exceptions;

import java.util.NoSuchElementException;

public class TraineeNotFoundException extends NoSuchElementException {
    public TraineeNotFoundException(String message) {
        super(message);
    }
}
