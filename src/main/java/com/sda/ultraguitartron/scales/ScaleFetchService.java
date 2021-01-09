package com.sda.ultraguitartron.scales;

import com.sda.ultraguitartron.exceptions.ScaleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ScaleFetchService {

    private final ScaleRepository scaleRepository;

    Scale fetchScaleById(Long id) {
        return scaleRepository.findById(id)
                .orElseThrow(() -> new ScaleNotFoundException("Cannot find scale with ID: " + id));
    }

    List<Scale> fetchAllScales() {
        return scaleRepository.findAll();
    }
}
