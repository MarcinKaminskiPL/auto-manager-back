package net.mkaminski.autoManagerBackend.services;

import lombok.RequiredArgsConstructor;
import net.mkaminski.autoManagerBackend.model.CarRepo;
import net.mkaminski.autoManagerBackend.model.Car;
import net.mkaminski.autoManagerBackend.model.ExpenseRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepo carRepo;
    private final ExpenseRepo expenseRepo;

    public List<Car> getCars() {
        return carRepo.findAll();
    }

    Optional<Car> getCar(long id) {
        return carRepo.findById(id);
    }

    public void add(Car car) {
        carRepo.save(car);
    }

    public boolean existsById(Long id) {
        return carRepo.existsById(id);
    }

    public void deleteById(Long id) {
        carRepo.findById(id).get().getExpenses().forEach(expense -> {
            expenseRepo.deleteById(expense.getId());
        });
        carRepo.deleteById(id);
    }
}
