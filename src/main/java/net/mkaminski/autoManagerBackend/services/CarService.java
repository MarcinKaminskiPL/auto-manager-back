package net.mkaminski.autoManagerBackend.services;

import lombok.RequiredArgsConstructor;
import net.mkaminski.autoManagerBackend.model.entities.Car;
import net.mkaminski.autoManagerBackend.model.repositories.CarRepository;
import net.mkaminski.autoManagerBackend.model.repositories.ExpenseRepository;
import net.mkaminski.autoManagerBackend.model.repositories.TripRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final ExpenseRepository expenseRepository;
    private final TripRepository tripRepository;

    public List<Car> getCars() {
        return carRepository.findAll();
    }
    public Page<Car> getCars(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    public Optional<Car> getCar(long id) {
        return carRepository.findById(id);
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public boolean existsById(Long id) {
        return carRepository.existsById(id);
    }

    public void deleteById(Long id) {
        carRepository.findById(id).get().getExpenses().forEach(expense -> {
            expenseRepository.deleteById(expense.getId());
        });
        carRepository.findById(id).get().getTrips().forEach(trip -> {
            tripRepository.deleteById(trip.getId());
        });
        carRepository.deleteById(id);
    }

    public long numberOfCars() {
        return carRepository.count();
    }

    public double getAverageOdometerStatus() {
        if (carRepository.count() > 0) {
            return carRepository.findAll().stream().mapToDouble(Car::getOdometerstatus).average().getAsDouble();
        } else {
            return 0;
        }
    }

    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }
}
