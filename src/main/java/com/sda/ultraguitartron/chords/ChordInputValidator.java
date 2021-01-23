package com.sda.ultraguitartron.chords;

import com.sda.ultraguitartron.exceptions.InvalidNameException;
import com.sda.ultraguitartron.exceptions.InvalidNoteInputException;
import org.springframework.stereotype.Component;

@Component
public class ChordInputValidator {

    void isInputDataCorrect(ChordDto chordDto) {
        if (!isFirstNoteNotNull(chordDto.getFirstNote())) {
            throw new InvalidNoteInputException("First note shouldn't be null.");
        } else if (!isSecondNoteNotNull(chordDto.getSecondNote())) {
            throw new InvalidNoteInputException("Second note shouldn't be null.");
        } else if (!isThirdNoteNotNull(chordDto.getThirdNote())) {
            throw new InvalidNoteInputException("Third note shouldn't be null.");
        } else if (!isFourthNoteNotNull(chordDto.getFourthNote())) {
            throw new InvalidNoteInputException("Fourth note shouldn't be null, if the chord does not have fourth note, please repeat first note position.");
        } else if (!isChordNameNotEmpty(chordDto.getChordName())) {
            throw new InvalidNameException("Chord name shouldn't be blank.");
        }
    }

    boolean isChordNameNotEmpty(String chordName) {
        return chordName.isEmpty();
    }

    boolean isFirstNoteNotNull(Integer firstNote) {
        return firstNote != null;
    }

    boolean isSecondNoteNotNull(Integer secondNote) {
        return secondNote != null;
    }

    boolean isThirdNoteNotNull(Integer thirdNote) {
        return thirdNote != null;
    }

    boolean isFourthNoteNotNull(Integer fourthNote) {
        return fourthNote != null;
    }
}