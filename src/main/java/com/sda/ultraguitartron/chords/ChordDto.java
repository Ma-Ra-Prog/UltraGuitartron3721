package com.sda.ultraguitartron.chords;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class ChordDto {

    Long id;

    @NotBlank(message = "Chord name is mandatory.")
    String chordName;
    @NotNull(message = "First note is mandatory.")
    Integer firstNote;
    @NotNull(message = "Second note is mandatory.")
    Integer secondNote;
    @NotNull(message = "Third note is mandatory.")
    Integer thirdNote;
    @NotNull(message = "Fourth note is mandatory.")
    Integer fourthNote;
}