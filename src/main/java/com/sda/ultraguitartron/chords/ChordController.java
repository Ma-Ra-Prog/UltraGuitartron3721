package com.sda.ultraguitartron.chords;

import com.sda.ultraguitartron.trainee.Trainee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ChordController {

    private final ChordFetchService chordFetchService;
    private final ChordCreateService chordCreateService;
    private final ChordMapper chordMapper;

    @GetMapping("/chords")
        //endpoint do dostania wszystkich typów akordów czyli id i nazwa.
    ResponseEntity<List<ChordDto>> getAllChords() {
        List<ChordDto> chordDtoList = chordFetchService
                .fetchAllChords()
                .stream()
                .map(chordMapper::mapToSimpleChordDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(chordDtoList);
    }

    //web dto
    //serwis, dto, encje
    //db, encje

    @GetMapping("/chords/{id}")
        //endpoint do dostania konkretnego akordu
    ChordDto getChordById(@PathVariable Long id) {
        Chord chord = chordFetchService.fetchChordById(id);
        return chordMapper.mapToChordDto(chord);
    }

    @PostMapping("/chords")
    public ResponseEntity<ChordDto> createNewChord(@Valid @RequestBody ChordDto chordDto, Trainee trainee,
                                                   @AuthenticationPrincipal Authentication authentication) { //todo: poprawić działanie z trainee
        authentication.getPrincipal();// User -> (User)
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        ChordDefinition chordDefinition = chordMapper.mapToChordDefinition(chordDto);
        Chord newlyCreatedChord = chordCreateService.createNewChord(chordDefinition, trainee);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(chordMapper.mapToChordDto(newlyCreatedChord));
    }
}
