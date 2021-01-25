package com.sda.ultraguitartron.counting.chords;

import com.sda.ultraguitartron.chords.Chord;
import com.sda.ultraguitartron.notes.Note;
import com.sda.ultraguitartron.trainee.Trainee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountingChords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Note note;
    @ManyToOne
    private Chord chord;
    private Boolean isFirstNoteCorrect;
    private Boolean isSecondNoteCorrect;
    private Boolean isThirdNoteCorrect;
    private Boolean isFourthNoteCorrect;
    private Boolean isFullyCorrect;
    @ManyToOne
    Trainee trainee;

}