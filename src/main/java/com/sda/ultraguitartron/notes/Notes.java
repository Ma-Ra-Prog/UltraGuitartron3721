package com.sda.ultraguitartron.notes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notes {
    private List<NoteDto> noteDtoList;
}