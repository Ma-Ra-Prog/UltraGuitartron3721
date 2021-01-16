package com.sda.ultraguitartron.scales;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScaleRepository extends JpaRepository<Scale, Long> {

    Optional<Scale> findByScaleName(String name);
}
