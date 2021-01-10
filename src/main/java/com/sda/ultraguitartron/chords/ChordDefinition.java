package com.sda.ultraguitartron.chords;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChordDefinition {

    private String chordName;
    private Integer firstNote;
    private Integer secondNote;
    private Integer thirdNote;
    private Integer fourthNote;
}