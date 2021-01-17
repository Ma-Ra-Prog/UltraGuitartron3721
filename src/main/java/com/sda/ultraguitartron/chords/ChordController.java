package com.sda.ultraguitartron.chords;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChordController {

    private final ChordCrudService chordCrudService;

    @GetMapping("/chords")
    @ResponseStatus(HttpStatus.OK) //Endpoint do dostania wszystkich chordów
    public Chords getAllChords() {
        return new Chords(chordCrudService.fetchAllChords());
    }

    //web dto
    //serwis, dto, encje
    //db, encje

    @GetMapping("/chords/{id}")
    @ResponseStatus(HttpStatus.OK) //endpoint do dostania konkretnego akordu
    public ChordDto getChordById(@PathVariable Long id) {
        return chordCrudService.fetchChordById(id);
    }

    @PostMapping("/chords")
    @ResponseStatus(HttpStatus.CREATED)
    public ChordDto createNewChord(@Valid @RequestBody ChordDto chordDto,
                                   @AuthenticationPrincipal Object user) {
        return chordCrudService.createNewChord(chordDto, null);
    }

    @GetMapping(value = "/chords/search", params = {"chordName", "rootNote"})
    @ResponseStatus(HttpStatus.OK)
    public SpecificChord getChordNotesByChordNameAndRootNote(@RequestParam String chordName,
                                                             @RequestParam(required = false, defaultValue = "C") String rootNote){
        return chordCrudService.fetchChordByNameAndRootNote(chordName, rootNote);
    }
}