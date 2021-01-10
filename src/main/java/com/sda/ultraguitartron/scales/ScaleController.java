package com.sda.ultraguitartron.scales;

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
public class ScaleController {

    private final ScaleCrudService scaleCrudService;
    private final ScaleMapper scaleMapper;

    @GetMapping("/scales")
    ResponseEntity<List<ScaleDto>> getAllScales() {
        List<ScaleDto> scaleDtoList = scaleCrudService
                .fetchAllScales()
                .stream()
                .map(scaleMapper::mapToScaleDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(scaleDtoList);
    }

    @GetMapping("/scales/{id}")
    ScaleDto getScaleById(@PathVariable Long id) {
        Scale scale = scaleCrudService.fetchScaleById(id);
        return scaleMapper.mapToScaleDto(scale);
    }

    //todo: dodać PostMapping
}
