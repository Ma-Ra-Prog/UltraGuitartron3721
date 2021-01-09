package com.sda.ultraguitartron.trainee;

import com.sda.ultraguitartron.exceptions.TraineeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TraineeFetchService {

    private final TraineeRepository traineeRepository;

    public Trainee fetchTraineeById(Long id) {
        return traineeRepository.findById(id)
                .orElseThrow(() -> new TraineeNotFoundException("Can't find trainee with ID: " + id));
    }

    public List<Trainee> fetchAllTrainees() {
        return traineeRepository.findAll();
    }
}
