package com.sda.ultraguitartron.chords;

import com.sda.ultraguitartron.exceptions.ChordNotFoundException;
import com.sda.ultraguitartron.trainee.Trainee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ChordCrudService { // ChordCrudService

    private final ChordRepository chordRepository;
    private final ChordMapper chordMapper;
    private final ChordInputValidator chordInputValidator;

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
}
