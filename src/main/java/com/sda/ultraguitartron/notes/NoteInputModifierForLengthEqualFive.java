package com.sda.ultraguitartron.notes;

import org.springframework.stereotype.Component;

@Component
public class NoteInputModifierForLengthEqualFive implements NoteInputModifier {
    @Override
    public String modify(String input) {
        String noteRefactorHelper;
        noteRefactorHelper = input.substring(0, 1).toUpperCase()
                + input.substring(1, 3)
                + input.substring(3, 4).toUpperCase()
                + input.charAt(4);
        return noteRefactorHelper;
    }

    @Override
    public int getId() {
        return 5;
    }
}