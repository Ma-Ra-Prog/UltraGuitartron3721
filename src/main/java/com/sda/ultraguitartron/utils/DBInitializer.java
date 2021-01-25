package com.sda.ultraguitartron.utils;


import com.sda.ultraguitartron.chords.Chord;
import com.sda.ultraguitartron.chords.ChordRepository;
import com.sda.ultraguitartron.exceptions.TuningNotFoundException;
import com.sda.ultraguitartron.notes.Note;
import com.sda.ultraguitartron.notes.NoteRepository;
import com.sda.ultraguitartron.trainee.Trainee;
import com.sda.ultraguitartron.trainee.TraineeRepository;
import com.sda.ultraguitartron.tuning.Tuning;
import com.sda.ultraguitartron.tuning.TuningRepository;
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
    private final TuningRepository tuningRepository;

    private static final String NOTE_C = "C";
    private static final String NOTE_C_SHARP_D_FLAT = "C#/Db";
    private static final String NOTE_D = "D";
    private static final String NOTE_D_SHARP_E_FLAT = "D#/Eb";
    private static final String NOTE_E = "E";
    private static final String NOTE_F = "F";
    private static final String NOTE_F_SHARP_G_FLAT = "F#/Gb";
    private static final String NOTE_G = "G";
    private static final String NOTE_G_SHARP_A_FLAT = "G#/Ab";
    private static final String NOTE_A = "A";
    private static final String NOTE_A_SHARP_B_FLAT = "A#/Bb";
    private static final String NOTE_B = "B";

    private static final String CHORD_MAJ7_NAME = "maj7";
    private static final List<Integer> CHORD_MAJ7_NOTES_VALUES = List.of(1, 5, 8, 12);
    private static final String CHORD_7_NAME = "7";
    private static final List<Integer> CHORD_7_NOTES_VALUES = List.of(1, 5, 8, 11);
    private static final String CHORD_M7_NAME = "m7";
    private static final List<Integer> CHORD_M7_NOTES_VALUES = List.of(1, 4, 8, 11);
    private static final String CHORD_M7B5_NAME = "m7/b5";
    private static final List<Integer> CHORD_M7B5_NOTES_VALUES = List.of(1, 4, 7, 11);

    private static final String E_STANDARD_TUNING_NAME = "E standard";
    private static final Integer E_STANDARD_TUNING_STRING_NUMBER = 6;
    private static final List<String> E_STANDARD_TUNING_STRINGS_NOTES_VALUES = List.of("E", "B", "G", "D", "A", "E");

    @Override
    public void run(String... args) throws Exception {
        Trainee defaultAdmin = new Trainee(null, "Default", "admin1", true, null, null);
        traineeRepository.save(defaultAdmin);

        saveIfNoteNotExist(NOTE_C);
        saveIfNoteNotExist(NOTE_C_SHARP_D_FLAT);
        saveIfNoteNotExist(NOTE_D);
        saveIfNoteNotExist(NOTE_D_SHARP_E_FLAT);
        saveIfNoteNotExist(NOTE_E);
        saveIfNoteNotExist(NOTE_F);
        saveIfNoteNotExist(NOTE_F_SHARP_G_FLAT);
        saveIfNoteNotExist(NOTE_G);
        saveIfNoteNotExist(NOTE_G_SHARP_A_FLAT);
        saveIfNoteNotExist(NOTE_A);
        saveIfNoteNotExist(NOTE_A_SHARP_B_FLAT);
        saveIfNoteNotExist(NOTE_B);

        saveIfChordNotExist(defaultAdmin, CHORD_MAJ7_NAME, CHORD_MAJ7_NOTES_VALUES);
        saveIfChordNotExist(defaultAdmin, CHORD_7_NAME, CHORD_7_NOTES_VALUES);
        saveIfChordNotExist(defaultAdmin, CHORD_M7_NAME, CHORD_M7_NOTES_VALUES);
        saveIfChordNotExist(defaultAdmin, CHORD_M7B5_NAME, CHORD_M7B5_NOTES_VALUES);

        saveTuningIfNotExist(defaultAdmin,
                E_STANDARD_TUNING_NAME,
                E_STANDARD_TUNING_STRING_NUMBER,
                E_STANDARD_TUNING_STRINGS_NOTES_VALUES);

//        defaultAdmin.setCurrentTuning(tuningRepository //todo: zrobić tak by przypisywało currentTuning do użytkownika
//                .findByTuningName(E_STANDARD_TUNING_NAME)
//                .orElseThrow(() -> new TuningNotFoundException("THIS SHOULD NOT HAPPEN")));
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

    private void saveIfNoteNotExist(String noteValue){
        if(noteRepository.findByNote(noteValue).isEmpty()){
            Note note = Note.builder()
                    .id(null)
                    .note(noteValue)
                    .countingChordsList(null)
                    .build();
            noteRepository.save(note);
        }
    }

    private void saveTuningIfNotExist(Trainee trainee, String tuningName, Integer stringNumber, List<String> notesValues){
        if(tuningRepository.findByTuningName(tuningName).isEmpty()){
            if(stringNumber==6){  //todo: metoda do zmiany na switcha od 4 do 7 strun (może więcej jeśli rozbuduje się program i encję tuningu)
                Tuning tuning = Tuning.builder()
                        .id(null)
                        .tuningName(tuningName)
                        .stringNumber(stringNumber)
                        .firstStringNote(notesValues.get(0))
                        .secondStringNote(notesValues.get(1))
                        .thirdStringNote(notesValues.get(2))
                        .fourthStringNote(notesValues.get(3))
                        .fifthStringNote(notesValues.get(4))
                        .sixthStringNote(notesValues.get(5))
                        .seventhStringNote(null)
                        .createdBy(trainee.getName())
                        .traineeList(null)
                        .build();
                tuningRepository.save(tuning);
            }
        }
    }
}