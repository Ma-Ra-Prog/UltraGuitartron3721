package com.sda.ultraguitartron.chords;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChordDefinition {

    private String chordName;
    private Integer firstNote;
    private Integer secondNote;
    private Integer thirdNote;
    private Integer fourthNote;

    public Optional<Integer> getFirstNote() {
        return Optional.ofNullable(firstNote);
    }

    public Optional<Integer> getSecondNote() {
        return Optional.ofNullable(secondNote);
    }

    public Optional<Integer> getThirdNote() {
        return Optional.ofNullable(thirdNote);
    }

    public Optional<Integer> getFourthNote() {
        return Optional.ofNullable(fourthNote);
    }

}
