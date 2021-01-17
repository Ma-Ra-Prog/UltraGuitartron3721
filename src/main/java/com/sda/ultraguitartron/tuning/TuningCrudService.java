package com.sda.ultraguitartron.tuning;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sda.ultraguitartron.exceptions.IllegalTraineeAccessException;
import com.sda.ultraguitartron.exceptions.TuningNotFoundException;
import com.sda.ultraguitartron.trainee.Trainee;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TuningCrudService {

    private final TuningRepository tuningRepository;
    private final TuningMapper tuningMapper;

    public List<TuningDto> fetchAllTunings() {
        return tuningRepository.findAll()
                .stream()
                .map(tuningMapper::mapToTuningDto)
                .collect(Collectors.toList());
    }

    public TuningDto fetchTuningById(Long id) {
        Tuning tuning = tuningRepository
                .findById(id)
                .orElseThrow(() -> new TuningNotFoundException("Cannot find tuning with ID: " + id));
        return tuningMapper.mapToTuningDto(tuning);
    }

    public TuningDto createNewTuning(TuningDto tuningDto, Trainee trainee) {
        Tuning tuning = tuningMapper.mapToTuning(tuningDto);
        tuning.setCreatedBy(trainee.getName());
        return tuningMapper.mapToTuningDto(tuningRepository.save(tuning));
    }

    public TuningDto deleteTuningByTuningName(String tuningName, Trainee trainee) {
        if (isAllowedToRemoveTuning(trainee, tuningName)) {
            return tuningRepository
                    .deleteTuningByTuningName(tuningName)
                    .map(tuningMapper::mapToTuningDto)
                    .orElseThrow(() -> new TuningNotFoundException("Cannot find and delete tuning with name: " + tuningName));
        }
        throw new IllegalTraineeAccessException("You cannot delete tuning with name: " + tuningName);
    }

    private boolean isAllowedToRemoveTuning(Trainee trainee, String tuningName) {
        return trainee.getName().equals(fetchTuningByTuningName(tuningName).getCreatedBy()) || trainee.isAdminPermission();
    }

    public TuningDto fetchTuningByTuningName(String tuningName) {
        Tuning tuning = tuningRepository
            .findByTuningName(tuningName)
            .orElseThrow(() -> new TuningNotFoundException("Cannot find tuning with name: " + tuningName));
        return tuningMapper.mapToTuningDto(tuning);
    }
}
