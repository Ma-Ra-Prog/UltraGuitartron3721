package com.sda.ultraguitartron.scales.search;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Component;

import com.sda.ultraguitartron.scales.ScaleDto;
import com.sda.ultraguitartron.scales.ScaleMapper;
import com.sda.ultraguitartron.scales.ScaleRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ScaleSearchService {

  private final ScaleRepository scaleRepository;
  private final ScaleMapper scaleMapper;

  public ScaleDto fetchScaleByName(String name) {
    return scaleRepository.findByName(name)
        .map(scaleMapper::mapToScaleDto)
        .orElseThrow(NoSuchElementException::new);
  }
}
