package com.sda.ultraguitartron.trainee;

import com.sda.ultraguitartron.exceptions.IllegalTraineeAccessException;
import com.sda.ultraguitartron.exceptions.TraineeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TraineeCrudService {

    private final TraineeRepository traineeRepository;
    private final TraineeMapper traineeMapper;

    public TraineeDto fetchTraineeById(Long id) {
        Trainee trainee = traineeRepository
                .findById(id)
                .orElseThrow(() -> new TraineeNotFoundException("Can't find trainee with ID: " + id));
        return traineeMapper.mapToTraineeDto(trainee);
    }

    public List<TraineeDto> fetchAllTrainees() {
        return traineeRepository.findAll()
                .stream()
                .map(traineeMapper::mapToTraineeDto)
                .collect(Collectors.toList());
    }

    public TraineeDto fetchTraineeByName(String name) {
        Trainee trainee = traineeRepository
                .findByName(name)
                .orElseThrow(() -> new TraineeNotFoundException("Can't find trainee with name: " + name));
        return traineeMapper.mapToTraineeDto(trainee);
    }

    public TraineeDto createNewTrainee(TraineeDto traineeDto) {
        Trainee trainee = traineeMapper.mapToTrainee(traineeDto);
        return traineeMapper.mapToTraineeDto(traineeRepository.save(trainee));
    }

    public TraineeDto deleteTraineeByName(String name, Trainee trainee) {
        Trainee deletedTrainee;
        if (trainee.isAdminPermission() || trainee.getName().equals(name)) {
            deletedTrainee = traineeRepository
                    .deleteByName(name)
                    .orElseThrow(() -> new TraineeNotFoundException("Can't find and delete trainee with name: " + name));
        } else {
            throw new IllegalTraineeAccessException("You cannot delete trainee with name: " + name);
        }
        return traineeMapper.mapToTraineeDto(deletedTrainee);
    }
}