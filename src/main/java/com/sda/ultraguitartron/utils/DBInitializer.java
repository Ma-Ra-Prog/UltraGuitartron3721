package com.sda.ultraguitartron.utils;


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

    private final TraineeRepository traineeRepository;
    private final ScaleRepository scaleRepository;

    @Override
    public void run(String... args) throws Exception {
        Trainee defaultAdmin = new Trainee(null, "Default", true);
        traineeRepository.save(defaultAdmin);
        if (scaleRepository.findByName("Jońska").isEmpty()) {
            Scale ionian = new Scale(null, "Jońska", 1, 3, 5, 6, 8, 10, 12, defaultAdmin.getName());
            scaleRepository.save(ionian);
        }
        if (scaleRepository.findByName("Dorycka").isEmpty()) {
            Scale dorian = new Scale(null, "Dorycka", 1, 3, 4, 6, 8, 10, 11, defaultAdmin.getName());
            scaleRepository.save(dorian);
        }
        if (scaleRepository.findByName("Frygijska").isEmpty()) {
            Scale phrygian = new Scale(null, "Frygijska", 1, 2, 4, 6, 8, 10, 11, defaultAdmin.getName());
            scaleRepository.save(phrygian);
        }
        if (scaleRepository.findByName("Lidyjska").isEmpty()) {
            Scale lydian = new Scale(null, "Lidyjska", 1, 3, 5, 7, 8, 10, 12, defaultAdmin.getName());
            scaleRepository.save(lydian);
        }
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