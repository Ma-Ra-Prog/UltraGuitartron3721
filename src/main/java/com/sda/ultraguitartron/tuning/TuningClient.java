package com.sda.ultraguitartron.tuning;

import java.util.List;

import org.springframework.web.client.RestTemplate;

public class TuningClient {

  private RestTemplate restTemplate = new RestTemplate();

  public void getTunings() {
    restTemplate.getForObject("http://localhost:8080/tunings", Tunings.class);
  }
}

