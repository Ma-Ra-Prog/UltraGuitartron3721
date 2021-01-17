package com.sda.ultraguitartron.chords;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chords {
    private List<ChordDto> chordDtoList;
}
