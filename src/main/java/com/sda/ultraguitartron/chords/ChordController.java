package com.sda.ultraguitartron.chords;

import com.sda.ultraguitartron.trainee.Trainee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ChordController {

    private final ChordFetchService chordFetchService;
    private final ChordCreateService chordCreateService;
    private final ChordMapper chordMapper;

    @GetMapping("/chords")  //endpoint do dostania wszystkich typów akordów czyli id i nazwa.
    ResponseEntity<List<ChordDto>> getAllChords() {
        List<ChordDto> chordDtoList = chordFetchService
                .fetchAllChords()
                .stream()
                .map(chordMapper::mapToSimpleChordDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(chordDtoList);
    }

    @GetMapping("/chords/{id}") //endpoint do dostania konkretnego akordu
    ChordDto getChordById(@PathVariable Long id) {
        Chord chord = chordFetchService.fetchChordById(id);
        return chordMapper.mapToChordDto(chord);
    }

    @PostMapping("/chords")
    ResponseEntity<ChordDto> createNewChord(@RequestBody ChordDto chordDto, Trainee trainee){ //todo: poprawić działanie z trainee
        ChordDefinition chordDefinition = chordMapper.mapToChordDefinition(chordDto);
        Chord newlyCreatedChord = chordCreateService.createNewChord(chordDefinition, trainee);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(chordMapper.mapToChordDto(newlyCreatedChord));
    }
}
