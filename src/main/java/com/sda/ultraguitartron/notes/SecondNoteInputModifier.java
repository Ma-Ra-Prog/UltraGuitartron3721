package com.sda.ultraguitartron.notes;

import org.springframework.stereotype.Component;

@Component
public class SecondNoteInputModifier implements NoteInputModifier {
  @Override
  public String modify(final String input) {
    String noteRefactorHelper = input.substring(0, 1).toUpperCase();
    return noteRefactorHelper + input.charAt(1);
  }

  @Override
  public int getId() {
    return 2;
  }
}
