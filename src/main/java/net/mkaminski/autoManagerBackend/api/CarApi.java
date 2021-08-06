package net.mkaminski.autoManagerBackend.api;

import lombok.RequiredArgsConstructor;
import net.mkaminski.autoManagerBackend.model.Car;
import net.mkaminski.autoManagerBackend.services.CarService;
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
    ResponseEntity<List<Car>> getCars(){
        return ResponseEntity.ok(carService.getCars());
    }

    @PostMapping
    ResponseEntity<Car> addCar(@RequestBody Car car){
        carService.add(car);
        return ResponseEntity.created(URI.create("/"+car.getId())).body(car);
    }
}
