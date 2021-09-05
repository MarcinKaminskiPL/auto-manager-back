package net.mkaminski.autoManagerBackend.model.repositories;

import net.mkaminski.autoManagerBackend.model.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
