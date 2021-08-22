package net.mkaminski.autoManagerBackend.api;

import lombok.RequiredArgsConstructor;
import net.mkaminski.autoManagerBackend.model.Trip;
import net.mkaminski.autoManagerBackend.services.CarService;
import net.mkaminski.autoManagerBackend.services.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/trips")
@RequiredArgsConstructor
public class TripApi {
    private final TripService tripService;
    private final CarService carService;

    @GetMapping
    ResponseEntity<List<Trip>> getTrips() {
        return ResponseEntity.ok(tripService.getTrips());
    }

    @PostMapping
    ResponseEntity addTrip(@RequestBody Trip trip) {
        if (carService.existsById(trip.getCarId())) {
            tripService.add(trip);
            return ResponseEntity.created(URI.create("/" + trip.getId())).body(trip);
        } else {
            return ResponseEntity.badRequest().body("car with id \"" + trip.getCarId() + "\" does not exist in the database");
        }
    }
    @DeleteMapping("{id}")
    ResponseEntity deleteTrip(@PathVariable Long id){
        if(tripService.existById(id)){
            tripService.deleteById(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
