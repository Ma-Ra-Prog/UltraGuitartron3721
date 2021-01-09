package com.sda.ultraguitartron.chords;

import com.sda.ultraguitartron.trainee.Trainee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChordCreateService {

    private final ChordRepository chordRepository;
    private final ChordInputValidator chordInputValidator;

    Chord createNewChord(ChordDefinition chordDefinition, Trainee trainee) {
        chordInputValidator.isInputDataCorrect(chordDefinition);

        Chord chord = new Chord();
        chord.setChordName(chordDefinition.getChordName());
        chord.setFirstNote(chordDefinition.getFirstNote().get());
        chord.setSecondNote(chordDefinition.getSecondNote().get());
        chord.setThirdNote(chordDefinition.getThirdNote().get());
        chord.setFourthNote(chordDefinition.getFourthNote().get());
        chord.setCreatedBy(trainee.getName());

        return chordRepository.save(chord);
    }
}
