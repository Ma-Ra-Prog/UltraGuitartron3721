package com.sda.ultraguitartron.chords;

import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class ChordMapper {

    ChordDto mapToSimpleChordDto(Chord chord) {  //proste wyświetlenie ChordDto do pobrania wszystkich typów akordów
        return ChordDto.builder()
                .id(chord.getId())
                .chordName(chord.getChordName())
                .build();
    }

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

    ChordDefinition mapToChordDefinition(ChordDto chordDto) {
        return ChordDefinition.builder()
                .chordName(chordDto.getChordName())
                .firstNote(chordDto.getFirstNote())
                .secondNote(chordDto.getSecondNote())
                .thirdNote(chordDto.getThirdNote())
                .fourthNote(chordDto.getFourthNote())
                .build();
    }

    Chord mapToChord(ChordDefinition chordDefinition) {
        return Chord.builder()
                .chordName(chordDefinition.getChordName())
                .firstNote(chordDefinition.getFirstNote())
                .secondNote(chordDefinition.getSecondNote())
                .thirdNote(chordDefinition.getThirdNote())
                .fourthNote(chordDefinition.getFourthNote())
                .build();
    }
}
