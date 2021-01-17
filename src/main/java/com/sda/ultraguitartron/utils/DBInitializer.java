package com.sda.ultraguitartron.utils;


import com.sda.ultraguitartron.scales.Scale;
import com.sda.ultraguitartron.scales.ScaleRepository;
import com.sda.ultraguitartron.trainee.Trainee;
import com.sda.ultraguitartron.trainee.TraineeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DBInitializer implements CommandLineRunner {

    private static final String SCALE_IONIAN_NAME = "Jońska";
    private static final List<Integer> IONIAN_NOTES_VALUES = List.of(1, 3, 5, 6, 8, 10, 12);

    private static final String SCALE_DORIAN_NAME = "Dorycka";
    private static final List<Integer> DORIAN_NOTES_VALUES = List.of(1, 3, 4, 6, 8, 10, 11);

    private static final String SCALE_PHRYGIAN_NAME = "Frygijska";
    private static final List<Integer> PHRYGIAN_NOTES_VALUES = List.of(1, 2, 4, 6, 8, 10, 11);

    private static final String SCALE_LYDIAN_NAME = "Lidyjska";
    private static final List<Integer> LYDIAN_NOTES_VALES = List.of(1, 3, 5, 7, 8, 10, 12);

    private static final String SCALE_MIXOLYDIAN_NAME = "Miksolidyjska";
    private static final List<Integer> MIXOLYDIAN_NOTES_VALUES = List.of(1, 3, 5, 6, 8, 10, 11);

    private static final String SCALE_AEOLIAN_NAME = "Eolska";
    private static final List<Integer> AEOLIAN_NOTES_VALUES = List.of(1, 3, 4, 6, 8, 9, 11);

    private static final String SCALE_PHRYSGIAN_DOMINANT_NAME = "Frygijska Dominantowa";
    private static final List<Integer> PHRYGIAN_DOMMINANT_NOTES_VALUE = List.of(1, 2, 5, 6, 8, 9, 11);

    private static final String SCALE_LOCRIAN_NAME = "Lorycka";
    private static final List<Integer> LOCRIAN_NOTES_VALUES = List.of(1, 2, 4, 6, 7, 9, 11);

    private static final String SCALE_HARMONIC_MINOR_NAME = "Molowa Harmoniczna";
    private static final List<Integer> HARMONIC_MINOR_NOTES_VALUES = List.of(1, 3, 4, 6, 8, 9, 12);

    private final TraineeRepository traineeRepository;
    private final ScaleRepository scaleRepository;

    @Override
    public void run(String... args) throws Exception {
        Trainee defaultAdmin = new Trainee(null, "Default", true);
        traineeRepository.save(defaultAdmin);

        saveIfScaleNotExist(defaultAdmin, SCALE_IONIAN_NAME, IONIAN_NOTES_VALUES);
        saveIfScaleNotExist(defaultAdmin, SCALE_DORIAN_NAME, DORIAN_NOTES_VALUES);
        saveIfScaleNotExist(defaultAdmin, SCALE_PHRYGIAN_NAME, PHRYGIAN_NOTES_VALUES);
        saveIfScaleNotExist(defaultAdmin, SCALE_LYDIAN_NAME, LYDIAN_NOTES_VALES);
        saveIfScaleNotExist(defaultAdmin, SCALE_MIXOLYDIAN_NAME, MIXOLYDIAN_NOTES_VALUES);
        saveIfScaleNotExist(defaultAdmin, SCALE_AEOLIAN_NAME, AEOLIAN_NOTES_VALUES);
        saveIfScaleNotExist(defaultAdmin, SCALE_PHRYSGIAN_DOMINANT_NAME, PHRYGIAN_DOMMINANT_NOTES_VALUE);
        saveIfScaleNotExist(defaultAdmin, SCALE_LOCRIAN_NAME, LOCRIAN_NOTES_VALUES);
        saveIfScaleNotExist(defaultAdmin, SCALE_HARMONIC_MINOR_NAME, HARMONIC_MINOR_NOTES_VALUES);
    }

    private void saveIfScaleNotExist(Trainee trainee, String scaleName, List<Integer> notesValues) {
        if (scaleRepository.findByName(scaleName).isEmpty()) {
            Scale locrian = Scale.builder()
                    .id(null)
                    .firstNote(notesValues.get(0))
                    .secondNote(notesValues.get(1))
                    .thirdNote(notesValues.get(2))
                    .fourthNote(notesValues.get(3))
                    .fifthNote(notesValues.get(4))
                    .sixthNote(notesValues.get(5))
                    .seventhNote(notesValues.get(6))
                    .createdBy(trainee.getName())
                    .build();
            scaleRepository.save(locrian);
        }
    }
}
