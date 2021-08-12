package net.mkaminski.autoManagerBackend.model;

import net.mkaminski.autoManagerBackend.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
}
