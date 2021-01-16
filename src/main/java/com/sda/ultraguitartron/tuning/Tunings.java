package com.sda.ultraguitartron.tuning;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tunings {
  private List<TuningDto> tuningDtos;
}
