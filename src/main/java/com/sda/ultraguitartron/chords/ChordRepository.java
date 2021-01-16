package com.sda.ultraguitartron.chords;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChordRepository extends JpaRepository<Chord, Long> {

    Optional<Chord> findByChordName(String chordName);
}