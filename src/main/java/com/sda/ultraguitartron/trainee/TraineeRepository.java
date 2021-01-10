package com.sda.ultraguitartron.trainee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TraineeRepository extends JpaRepository<Trainee, Long> {

    Optional<Trainee> findByName(String name);

    Optional<Trainee> deleteByName(String name);
}