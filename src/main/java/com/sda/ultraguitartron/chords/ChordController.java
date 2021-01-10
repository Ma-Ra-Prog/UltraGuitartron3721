package com.sda.ultraguitartron.chords;

import com.sda.ultraguitartron.trainee.Trainee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChordController {

    private final ChordCrudService chordCrudService;

    @GetMapping("/chords")
    @ResponseStatus(HttpStatus.OK) //Endpoint do dostania wszystkich chordów
    public List<ChordDto> getAllChords() {
        return chordCrudService.fetchAllChords();
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
    public ChordDto createNewChord(@Valid @RequestBody ChordDto chordDto, Trainee trainee,
                                   @AuthenticationPrincipal Authentication authentication) { //todo: poprawić działanie z trainee
        Object principal = authentication.getPrincipal(); // User -> (User)
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return chordCrudService.createNewChord(chordDto, trainee);
    }
}