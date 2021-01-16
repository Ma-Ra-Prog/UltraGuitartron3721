package com.sda.ultraguitartron.notes;

import com.sda.ultraguitartron.exceptions.NoteNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class NoteService {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    public NoteDto fetchNoteById(Long id) {
        return noteRepository.findById(id)
                .map(noteMapper::mapToNoteDto)
                .orElseThrow(() -> new NoteNotFoundException("Note not found"));
    }

    List<NoteDto> fetchAll() {
        return noteRepository.findAll()
                .stream()
                .map(noteMapper::mapToNoteDto)
                .collect(Collectors.toList());
    }

    public NoteDto fetchNoteByName(String name) {
        return noteRepository.findByNote(name)
                .map(noteMapper::mapToNoteDto)
                .orElseThrow(NoSuchElementException::new);
    }
}