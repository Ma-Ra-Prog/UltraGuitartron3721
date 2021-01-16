package com.sda.ultraguitartron.notes;

import org.springframework.stereotype.Component;

@Component
public class NoteMapper {

    public NoteDto mapToNoteDto(Note note) {
        return NoteDto.builder()
                .note(note.getNote())
                .build();
    }
}