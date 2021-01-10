package com.sda.ultraguitartron.utils;


import com.sda.ultraguitartron.trainee.Trainee;
import com.sda.ultraguitartron.trainee.TraineeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DBInitializer implements CommandLineRunner {

    private final TraineeRepository traineeRepository;

    @Override
    public void run(String... args) throws Exception {
        traineeRepository.save(new Trainee(null, "Nabuhodonozor", false));
    }
}
