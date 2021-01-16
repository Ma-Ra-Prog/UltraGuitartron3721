package com.sda.ultraguitartron.tuning;

import com.sda.ultraguitartron.trainee.Trainee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TuningController {

    private final TuningCrudService tuningCrudService;

    @GetMapping("/tunings")
    @ResponseStatus(HttpStatus.OK)
    public Tunings getAllTunings() {
        return new Tunings(tuningCrudService.fetchAllTunings());
    }

    @GetMapping("/tunings/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TuningDto getTuningById(@PathVariable Long id) {
        return tuningCrudService.fetchTuningById(id);
    }

    @PostMapping("/tunings")
    @ResponseStatus(HttpStatus.CREATED)
    public TuningDto createNewTuning(@Valid @RequestBody TuningDto tuningDto, Trainee trainee) {
        return tuningCrudService.createNewTuning(tuningDto, trainee);
    }

    @DeleteMapping("/tunings/{name}")
    @ResponseStatus(HttpStatus.OK)
    public TuningDto deleteTuningByName(String tuningName, Trainee trainee) {
        return tuningCrudService.deleteTuningByTuningName(tuningName, trainee);
    }
}
