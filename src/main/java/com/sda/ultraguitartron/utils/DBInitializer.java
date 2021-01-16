package com.sda.ultraguitartron.utils;


import com.sda.ultraguitartron.notes.Note;
import com.sda.ultraguitartron.notes.NoteRepository;
import com.sda.ultraguitartron.trainee.Trainee;
import com.sda.ultraguitartron.trainee.TraineeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DBInitializer implements CommandLineRunner {

    private final TraineeRepository traineeRepository;
    private final NoteRepository noteRepository;

    @Override
    public void run(String... args) throws Exception {
        traineeRepository.save(new Trainee(null, "Nabuchodonozor", false));
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
    }
}