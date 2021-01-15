package com.sda.ultraguitartron.scales;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ScaleDto createNewScale(@Valid @RequestBody ScaleDto scaleDto,
                                   @AuthenticationPrincipal Object user) {
        return scaleCrudService.createNewScale(scaleDto, null);
    }

    @GetMapping("/scales/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public ScaleDto getScaleByName(@PathVariable String name){
        return scaleCrudService.fetchScaleByName(name);
    }
}