package com.sda.ultraguitartron.tuning;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TuningRepository extends JpaRepository<Tuning, Long> {

    Optional<Tuning> deleteTuningByTuningName(String name);

    Optional<Tuning> findByTuningName(String name);
}