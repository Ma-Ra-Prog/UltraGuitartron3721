package com.sda.ultraguitartron.utils;


import com.sda.ultraguitartron.chords.Chord;
import com.sda.ultraguitartron.chords.ChordRepository;
import com.sda.ultraguitartron.notes.Note;
import com.sda.ultraguitartron.notes.NoteRepository;
import com.sda.ultraguitartron.trainee.Trainee;
import com.sda.ultraguitartron.trainee.TraineeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DBInitializer implements CommandLineRunner {

    private final TraineeRepository traineeRepository;
    private final NoteRepository noteRepository;
    private final ChordRepository chordRepository;

    private static final String CHORD_MAJ7_NAME = "maj7";
    private static final List<Integer> CHORD_MAJ7_NOTES_VALUES = List.of(1, 5, 8, 12);
    private static final String CHORD_7_NAME = "7";
    private static final List<Integer> CHORD_7_NOTES_VALUES = List.of(1, 5, 8, 11);
    private static final String CHORD_M7_NAME = "m7";
    private static final List<Integer> CHORD_M7_NOTES_VALUES = List.of(1, 4, 8, 11);
    private static final String CHORD_M7B5_NAME = "m7/b5";
    private static final List<Integer> CHORD_M7B5_NOTES_VALUES = List.of(1, 4, 7, 11);

    @Override
    public void run(String... args) throws Exception {
        Trainee defaultAdmin = new Trainee(null, "Default", true);
        traineeRepository.save(defaultAdmin);

        noteRepository.save(new Note(null,"C"));
        noteRepository.save(new Note(null,"C#/Db"));
        noteRepository.save(new Note(null,"D"));
        noteRepository.save(new Note(null,"D#/Eb"));
        noteRepository.save(new Note(null,"E"));
        noteRepository.save(new Note(null,"F"));
        noteRepository.save(new Note(null,"F#/Gb"));
        noteRepository.save(new Note(null,"G"));
        noteRepository.save(new Note(null,"G#/Ab"));
        noteRepository.save(new Note(null,"A"));
        noteRepository.save(new Note(null,"A#/Bb"));
        noteRepository.save(new Note(null,"B"));

        saveIfChordNotExist(defaultAdmin, CHORD_MAJ7_NAME, CHORD_MAJ7_NOTES_VALUES);
        saveIfChordNotExist(defaultAdmin, CHORD_7_NAME, CHORD_7_NOTES_VALUES);
        saveIfChordNotExist(defaultAdmin, CHORD_M7_NAME, CHORD_M7_NOTES_VALUES);
        saveIfChordNotExist(defaultAdmin, CHORD_M7B5_NAME, CHORD_M7B5_NOTES_VALUES);
    }

    private void saveIfChordNotExist(Trainee trainee, String chordName, List<Integer> notesValues) {
        if (chordRepository.findByChordName(chordName).isEmpty()) {
            Chord chord = Chord.builder()
                    .id(null)
                    .chordName(chordName)
                    .firstNote(notesValues.get(0))
                    .secondNote(notesValues.get(1))
                    .thirdNote(notesValues.get(2))
                    .fourthNote(notesValues.get(3))
                    .createdBy(trainee.getName())
                    .build();
            chordRepository.save(chord);
        }
    }
}