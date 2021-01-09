package com.sda.ultraguitartron.chords;

import com.sda.ultraguitartron.exceptions.ChordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChordFetchService {

    private final ChordRepository chordRepository;

    public Chord fetchChordById(Long id) {
        return chordRepository.findById(id)
                .orElseThrow(() -> new ChordNotFoundException("Cannot find chord with ID: " + id));
    }

    List<Chord> fetchAllChords() {
        return chordRepository.findAll();
    }
}
