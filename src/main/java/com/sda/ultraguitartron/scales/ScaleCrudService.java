package com.sda.ultraguitartron.scales;

import com.sda.ultraguitartron.exceptions.ScaleNotFoundException;
import com.sda.ultraguitartron.trainee.Trainee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ScaleCrudService {

    private final ScaleRepository scaleRepository;
    private final ScaleMapper scaleMapper;

    ScaleDto fetchScaleById(Long id) {
        return scaleRepository.findById(id)
                .map(scaleMapper::mapToScaleDto)
                .orElseThrow(() -> new ScaleNotFoundException("Cannot find scale with ID: " + id));
    }

    List<ScaleDto> fetchAllScales() {
        return scaleRepository.findAll()
                .stream()
                .map(scaleMapper::mapToScaleDto)
                .collect(Collectors.toList());
    }

    ScaleDto createNewScale(ScaleDto scaleDto, Trainee trainee) {
        ScaleDefinition scaleDefinition = scaleMapper.mapToDefinition(scaleDto);
        Scale scale = scaleMapper.mapToScale(scaleDefinition);
        scale.setCreatedBy(trainee.getName());
        final Scale savedScale = scaleRepository.save(scale);
        return scaleMapper.mapToScaleDto(savedScale);
    }
}
