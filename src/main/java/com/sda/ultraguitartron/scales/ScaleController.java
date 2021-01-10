package com.sda.ultraguitartron.scales;

import com.sda.ultraguitartron.trainee.Trainee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScaleController {

    private final ScaleCrudService scaleCrudService;

    @GetMapping("/scales")
    @ResponseStatus(code = HttpStatus.OK)
    List<ScaleDto> getAllScales() {
        return new ArrayList<>(scaleCrudService
                .fetchAllScales());
    }

    @GetMapping("/scales/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    ScaleDto getScaleById(@PathVariable Long id) {
        return scaleCrudService.fetchScaleById(id);
    }

    @PostMapping("/scales")
    @ResponseStatus(code = HttpStatus.CREATED)
    ScaleDto createNewScale(@RequestBody ScaleDto scaleDto, Trainee trainee) {
        return scaleCrudService.createNewScale(scaleDto, trainee);
    }
}
