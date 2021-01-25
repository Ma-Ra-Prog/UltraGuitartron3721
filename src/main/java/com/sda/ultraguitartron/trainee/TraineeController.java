package com.sda.ultraguitartron.trainee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TraineeController {

    private final TraineeCrudService traineeCrudService;

    @GetMapping("/Trainees")
    @ResponseStatus(HttpStatus.OK)
    public Trainees getAllTrainees() {
        return new Trainees(traineeCrudService.fetchAllTrainees());
    }

    @GetMapping("/Trainees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TraineeDto getTrainee(@PathVariable Long id) {
        return traineeCrudService.fetchTraineeById(id);
    }

    @PostMapping("/Trainees")
    @ResponseStatus(HttpStatus.CREATED)
    public TraineeDto createNewTrainee(@Valid @RequestBody TraineeDto traineeDto) {
        return traineeCrudService.createNewTrainee(traineeDto);
    }

    @DeleteMapping("/Trainees/{name}")
    @ResponseStatus(HttpStatus.OK)
    public TraineeDto deleteTraineeByName(String name, Trainee trainee) {
        return traineeCrudService.deleteTraineeByName(name, trainee);
    }
}