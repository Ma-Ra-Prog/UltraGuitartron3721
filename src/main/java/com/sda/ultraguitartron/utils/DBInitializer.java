package com.sda.ultraguitartron.utils;


import java.util.List;

import com.sda.ultraguitartron.scales.Scale;
import com.sda.ultraguitartron.scales.ScaleRepository;
import com.sda.ultraguitartron.trainee.Trainee;
import com.sda.ultraguitartron.trainee.TraineeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
    private static final List<Integer> PHRYIAN_NOTES_VALES = List.of(1, 3, 5, 7, 8, 10, 12);

    private final TraineeRepository traineeRepository;
    private final ScaleRepository scaleRepository;

    @Override
    public void run(String... args) throws Exception {
        Trainee defaultAdmin = new Trainee(null, "Default", true);
        traineeRepository.save(defaultAdmin);


        if (scaleRepository.findByName("Miksolidyjska").isEmpty()) {
            Scale mixolydian = new Scale(null, "Miksolidyjska", 1, 3, 5, 6, 8, 10, 11, defaultAdmin.getName());
            scaleRepository.save(mixolydian);
        }
        if (scaleRepository.findByName("Eolska").isEmpty()) {
            Scale aeolian = new Scale(null, "Eolska", 1, 3, 4, 6, 8, 9, 11, defaultAdmin.getName());
            scaleRepository.save(aeolian);
        }
        if (scaleRepository.findByName("Lorycka").isEmpty()) {
            Scale locrian = new Scale(null, "Lorycka", 1, 2, 4, 6, 7, 9, 11, defaultAdmin.getName());
            scaleRepository.save(locrian);
        }
        if (scaleRepository.findByName("Molowa Harmoniczna").isEmpty()) {
            Scale harmonicMinor = new Scale(null, "Molowa Harmoniczna", 1, 3, 4, 6, 8, 9, 12, defaultAdmin.getName());
            scaleRepository.save(harmonicMinor);
        }
        if (scaleRepository.findByName("Frygijska Dominantowa").isEmpty()) {
            Scale phrygianDominant = new Scale(null, "Frygijska Dominantowa", 1, 2, 5, 6, 8, 9, 11, defaultAdmin.getName());
            scaleRepository.save(phrygianDominant);
        }
    }
}
