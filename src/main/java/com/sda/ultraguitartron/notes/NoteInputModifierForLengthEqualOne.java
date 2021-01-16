package com.sda.ultraguitartron.notes;

import org.springframework.stereotype.Component;

@Component
public class NoteInputModifierForLengthEqualOne implements NoteInputModifier {
    @Override
    public String modify(String input) {
        return input.toUpperCase();
    }

    @Override
    public int getId() {
        return 1;
    }
}