package net.mkaminski.autoManagerBackend.services;

import lombok.RequiredArgsConstructor;
import net.mkaminski.autoManagerBackend.model.entities.Car;
import net.mkaminski.autoManagerBackend.model.repositories.CarRepo;
import net.mkaminski.autoManagerBackend.model.repositories.ExpenseRepo;
import net.mkaminski.autoManagerBackend.model.repositories.TripRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepo carRepo;
    private final ExpenseRepo expenseRepo;
    private final TripRepo tripRepo;

    public List<Car> getCars() {
        return carRepo.findAll();
    }

    public Optional<Car> getCar(long id) {
        return carRepo.findById(id);
    }

    public Car save(Car car) {
        return carRepo.save(car);
    }

    public boolean existsById(Long id) {
        return carRepo.existsById(id);
    }

    public void deleteById(Long id) {
        carRepo.findById(id).get().getExpenses().forEach(expense -> {
            expenseRepo.deleteById(expense.getId());
        });
        carRepo.findById(id).get().getTrips().forEach(trip -> {
            tripRepo.deleteById(trip.getId());
        });
        carRepo.deleteById(id);
    }

    public int numberOfCars() {
        return carRepo.findAll().size();
    }

    public double getAverageOdometerStatus() {
        if (carRepo.count() > 0) {
            return carRepo.findAll().stream().mapToDouble(Car::getOdometerstatus).average().getAsDouble();
        } else {
            return 0;
        }
    }

    public Optional<Car> findById(Long id) {
        return carRepo.findById(id);
    }
}
