package com.sda.ultraguitartron.notes;

import org.springframework.stereotype.Component;

@Component
public class FirstNoteInputModifier implements NoteInputModifier {
  @Override
  public String modify(final String input) {
    return input.toUpperCase();
  }

  @Override
  public int getId() {
    return 1;
  }
}
