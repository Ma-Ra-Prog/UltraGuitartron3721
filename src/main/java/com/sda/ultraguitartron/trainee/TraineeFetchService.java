package com.sda.ultraguitartron.trainee;

import com.sda.ultraguitartron.exceptions.TraineeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class TraineeFetchService {

    private final TraineeRepository traineeRepository;

    public Trainee fetchTraineeById(Long id) {
        return traineeRepository.findById(id)
                .orElseThrow(() -> new TraineeNotFoundException("Can't find trainee with ID: " + id));
    }

    public Trainee fetchTraineeByName(String name){
        return traineeRepository.findByName(name)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Trainee> fetchAllTrainees() {
        return traineeRepository.findAll();
    }
}
