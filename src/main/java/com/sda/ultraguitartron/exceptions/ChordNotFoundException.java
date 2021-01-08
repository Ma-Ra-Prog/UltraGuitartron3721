package com.sda.ultraguitartron.exceptions;

import java.util.NoSuchElementException;

public class ChordNotFoundException extends NoSuchElementException {

    public ChordNotFoundException(String message) {
        super(message);
    }
}
