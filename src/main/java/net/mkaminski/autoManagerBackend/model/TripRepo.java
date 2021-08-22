package net.mkaminski.autoManagerBackend.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepo extends JpaRepository<Trip, Long> {
}
