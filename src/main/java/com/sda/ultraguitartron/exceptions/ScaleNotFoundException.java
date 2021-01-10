package com.sda.ultraguitartron.exceptions;

import java.util.NoSuchElementException;

public class ScaleNotFoundException extends NoSuchElementException {
    public ScaleNotFoundException(String message) {
        super(message);
    }
}