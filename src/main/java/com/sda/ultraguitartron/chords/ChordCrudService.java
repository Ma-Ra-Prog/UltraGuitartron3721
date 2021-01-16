package com.sda.ultraguitartron.chords;

import com.sda.ultraguitartron.exceptions.ChordNotFoundException;
import com.sda.ultraguitartron.notes.NoteService;
import com.sda.ultraguitartron.trainee.Trainee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ChordCrudService { // ChordCrudService

    private final ChordRepository chordRepository;
    private final ChordMapper chordMapper;
    private final ChordInputValidator chordInputValidator;
    private final NoteService noteService;

    ChordDto fetchChordById(Long id) {
        Chord chord = chordRepository.findById(id)
                .orElseThrow(() -> new ChordNotFoundException("Cannot find chord with ID: " + id));
        return chordMapper.mapToChordDto(chord);
    }

    List<ChordDto> fetchAllChords() {
        return chordRepository.findAll()
                .stream()
                .map(chordMapper::mapToSimpleChordDto)
                .collect(Collectors.toList());
    }

    ChordDto createNewChord(ChordDto chordDto, Trainee trainee) {
        ChordDefinition chordDefinition = chordMapper.mapToChordDefinition(chordDto);
        chordInputValidator.isInputDataCorrect(chordDefinition);
        Chord chord = chordMapper.mapToChord(chordDefinition);
        chord.setCreatedBy(trainee.getName());
        return chordMapper.mapToChordDto(chordRepository.save(chord));
    }

    ChordDto fetchChordByName(String chordName){
        Chord chord = chordRepository
                .findByChordName(chordName)
                .orElseThrow(() -> new ChordNotFoundException("Cannot find chord with name: " + chordName));
        return chordMapper.mapToChordDto(chord);
    }

    public SpecificChord fetchChordByNameAndRootNote(String chordName, String rootNote) {
        ChordDto chordDto = fetchChordByName(chordName);
        Long rootNoteId = noteService.fetchNoteByName(rootNote).getId()-1;
        List<String> notesList = new ArrayList<>();
        notesList.add(noteService
                .fetchNoteById(ifGreaterThanTwelveThenMinusTwelve(Long.valueOf(chordDto.firstNote)+rootNoteId))
                .getNote());
        notesList.add(noteService
                .fetchNoteById(ifGreaterThanTwelveThenMinusTwelve(Long.valueOf(chordDto.secondNote)+rootNoteId))
                .getNote());
        notesList.add(noteService
                .fetchNoteById(ifGreaterThanTwelveThenMinusTwelve(Long.valueOf(chordDto.thirdNote)+rootNoteId))
                .getNote());
        notesList.add(noteService
                .fetchNoteById(ifGreaterThanTwelveThenMinusTwelve(Long.valueOf(chordDto.fourthNote)+rootNoteId))
                .getNote());
        return new SpecificChord(chordName, notesList);
    }

    private Long ifGreaterThanTwelveThenMinusTwelve(Long input){
        if (input>12){
            return input-12;
        } else {
            return input;
        }
    }
}