package com.sda.ultraguitartron.exceptions;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(String message){
        super(message);
    }
}
