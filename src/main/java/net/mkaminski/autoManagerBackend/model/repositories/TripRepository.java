package net.mkaminski.autoManagerBackend.model.repositories;

import net.mkaminski.autoManagerBackend.model.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
