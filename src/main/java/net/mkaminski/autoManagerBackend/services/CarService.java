package net.mkaminski.autoManagerBackend.services;

import lombok.RequiredArgsConstructor;
import net.mkaminski.autoManagerBackend.CarRepository;
import net.mkaminski.autoManagerBackend.model.Car;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    Optional<Car> getCar(long id) {
        return carRepository.findById(id);
    }

    public void add(Car car) {
        carRepository.save(car);
    }

    public boolean existsById(Long id) {
        return carRepository.existsById(id);
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
