package com.sda.ultraguitartron.scales;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScaleDto {

    Long id;
    String scaleName;
    Integer firstNote;
    Integer secondNote;
    Integer thirdNote;
    Integer fourthNote;
    Integer fifthNote;
    Integer sixthNote;
    Integer seventhNote;

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

    public Optional<Integer> getFifthNote() {
        return Optional.ofNullable(fifthNote);
    }

    public Optional<Integer> getSixthNote() {
        return Optional.ofNullable(sixthNote);
    }

    public Optional<Integer> getSeventhNote() {
        return Optional.ofNullable(seventhNote);
    }
}
