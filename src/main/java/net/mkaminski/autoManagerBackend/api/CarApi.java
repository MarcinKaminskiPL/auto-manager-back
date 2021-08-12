package net.mkaminski.autoManagerBackend.api;

import lombok.RequiredArgsConstructor;
import net.mkaminski.autoManagerBackend.model.Car;
import net.mkaminski.autoManagerBackend.services.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarApi {
    private final CarService carService;

    @GetMapping
    ResponseEntity<List<Car>> getCars() {
        return ResponseEntity.ok(carService.getCars());
    }

    @PostMapping
    ResponseEntity<Car> addCar(@RequestBody Car car) {
        carService.add(car);
        return ResponseEntity.created(URI.create("/" + car.getId())).body(car);
    }

    @DeleteMapping("{id}")
    ResponseEntity deleteCar(@PathVariable Long id) {
        if (carService.existsById(id)) {
            carService.deleteById(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
