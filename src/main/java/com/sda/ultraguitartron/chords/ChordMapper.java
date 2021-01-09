package com.sda.ultraguitartron.chords;

import org.springframework.stereotype.Component;

@Component
public class ChordMapper {

    ChordDto mapToSimpleChordDto(Chord chord) {  //proste wyświetlenie ChordDto do pobrania wszystkich typów akordów
        return new ChordDto().builder()
                .id(chord.getId())
                .chordName(chord.getChordName())
                .build();
    }

    ChordDto mapToChordDto(Chord chord) {
        return new ChordDto().builder()
                .id(chord.getId())
                .chordName(chord.getChordName())
                .firstNote(chord.getFirstNote())
                .secondNote(chord.getSecondNote())
                .thirdNote(chord.getThirdNote())
                .fourthNote(chord.getFourthNote())
                .build();
    }

    ChordDefinition mapToChordDefinition(ChordDto chordDto) {
        return new ChordDefinition().builder()
                .chordName(chordDto.getChordName())
                .firstNote(chordDto.getFirstNote().orElseGet(null))
                .secondNote(chordDto.getSecondNote().orElseGet(null))
                .thirdNote(chordDto.getThirdNote().orElseGet(null))
                .fourthNote(chordDto.getFourthNote().orElseGet(null))
                .build();


    }
}
