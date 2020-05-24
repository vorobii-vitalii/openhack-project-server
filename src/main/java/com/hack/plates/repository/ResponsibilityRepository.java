package com.hack.plates.repository;

import com.hack.plates.entity.Responsibility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResponsibilityRepository extends JpaRepository<Responsibility, Long> {
    Optional<Responsibility> findByName(String name);
}
