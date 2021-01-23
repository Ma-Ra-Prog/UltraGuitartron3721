package com.sda.ultraguitartron.notes;

import org.springframework.stereotype.Component;

@Component
public class NoteMapper {

    public NoteDto mapToNoteDto(Note note) {
        return NoteDto.builder()
                .id(note.getId())
                .note(note.getNote())
                .build();
    }
}