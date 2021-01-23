package com.sda.ultraguitartron.notes;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/notes")
    @ResponseStatus(code = HttpStatus.OK)
    public Notes getAllNote() {
        return new Notes(noteService.fetchAll());
    }

    @GetMapping("/notes/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public NoteDto getNoteById(@PathVariable Long id) {
        return noteService.fetchNoteById(id);
    }

    @GetMapping("/notes/name/{name}") //by nie było problemem z dwoma endpointami o takiej samej ścieżce i różniących się tylko inputem, dodane jest name by było wiadomo, że tu jest szukanie po nazwie
    @ResponseStatus(code = HttpStatus.OK)
    public NoteDto getNoteByName(@PathVariable String name){
        return noteService.fetchNoteByName(name);
    }
}