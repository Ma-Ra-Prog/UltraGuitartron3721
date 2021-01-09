package com.sda.ultraguitartron.trainee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TraineeController {

    private final TraineeFetchService traineeFetchService;
    private final TraineeMapper traineeMapper;

    @GetMapping("/Trainee")
    ResponseEntity<List<TraineeDto>> getAllTrainees() {
        List<TraineeDto> traineeDtoList = traineeFetchService
                .fetchAllTrainees()
                .stream()
                .map(traineeMapper::mapToTraineeDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(traineeDtoList);
    }

    @GetMapping("/Trainee/{id}")
    TraineeDto getTrainee(@PathVariable Long id) {
        Trainee trainee = traineeFetchService.fetchTraineeById(id);
        return traineeMapper.mapToTraineeDto(trainee);
    }

    //todo: zrobić postmapping dla trainee

}
