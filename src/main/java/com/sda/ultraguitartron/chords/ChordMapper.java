package com.sda.ultraguitartron.chords;

import org.springframework.stereotype.Component;

@Component
public class ChordMapper {

    ChordDto mapToChordDto(Chord chord) {
        return ChordDto.builder()
                .id(chord.getId())
                .chordName(chord.getChordName())
                .firstNote(chord.getFirstNote())
                .secondNote(chord.getSecondNote())
                .thirdNote(chord.getThirdNote())
                .fourthNote(chord.getFourthNote())
                .build();
    }

    Chord mapToChord(ChordDto chordDto) {
        return Chord.builder()
                .id(null)
                .chordName(chordDto.getChordName())
                .firstNote(chordDto.getFirstNote())
                .secondNote(chordDto.getSecondNote())
                .thirdNote(chordDto.getThirdNote())
                .fourthNote(chordDto.getFourthNote())
                .build();
    }
}