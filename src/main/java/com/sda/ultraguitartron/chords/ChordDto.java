package com.sda.ultraguitartron.chords;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChordDto {

    Long id;
    String chordName;
    Integer firstNote;
    Integer secondNote;
    Integer thirdNote;
    Integer fourthNote;

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
