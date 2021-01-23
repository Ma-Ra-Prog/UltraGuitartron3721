package com.sda.ultraguitartron.chords;

import com.sda.ultraguitartron.exceptions.ChordNotFoundException;
import com.sda.ultraguitartron.notes.NoteService;
import com.sda.ultraguitartron.trainee.Trainee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
@RequiredArgsConstructor
public class ChordCrudService { // ChordCrudService

    private final ChordRepository chordRepository;
    private final ChordMapper chordMapper;
    private final ChordInputValidator chordInputValidator;
    private final NoteService noteService;
    private final int CONSTANT_REMOVING_PLUS_ONE_SHIFT_ISSUE = 1;
    private final int CONSTANT_VALUE_OF_THE_ID_OF_THE_LAST_NOTE_IN_DB = 12;

    ChordDto fetchChordById(Long id) {
        Chord chord = chordRepository.findById(id)
                .orElseThrow(() -> new ChordNotFoundException("Cannot find chord with ID: " + id));
        return chordMapper.mapToChordDto(chord);
    }

    List<ChordDto> fetchAllChords() {
        return chordRepository.findAll()
                .stream()
                .map(chordMapper::mapToChordDto)
                .collect(Collectors.toList());
    }

    ChordDto createNewChord(ChordDto chordDto, Trainee trainee) {
        chordInputValidator.isInputDataCorrect(chordDto);
        Chord chord = chordMapper.mapToChord(chordDto);
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
        Long rootNoteId = noteService.fetchNoteByName(rootNote).getId()-CONSTANT_REMOVING_PLUS_ONE_SHIFT_ISSUE;
        final List<String> notesList = Stream.of(chordDto.getFirstNote(), chordDto.getSecondNote(), chordDto.getThirdNote(), chordDto.getFourthNote())
                .map(note -> noteService.fetchNoteById(ifGreaterThanLastIdValueThenStartFromFirst(Long.valueOf(note) + rootNoteId)).getNote())
                .collect(Collectors.toUnmodifiableList());
        return new SpecificChord(chordName, notesList);
    }

    private Long ifGreaterThanLastIdValueThenStartFromFirst(Long input){
        if (input>CONSTANT_VALUE_OF_THE_ID_OF_THE_LAST_NOTE_IN_DB){
            return input-CONSTANT_VALUE_OF_THE_ID_OF_THE_LAST_NOTE_IN_DB;
        } else {
            return input;
        }
    }
}