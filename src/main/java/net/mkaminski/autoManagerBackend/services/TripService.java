package net.mkaminski.autoManagerBackend.services;

import lombok.RequiredArgsConstructor;
import net.mkaminski.autoManagerBackend.model.entities.Trip;
import net.mkaminski.autoManagerBackend.model.repositories.TripRepo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {
    private final TripRepo tripRepo;

    public List<Trip> getTrips(){
        return tripRepo.findAll();
    }
    public void add(Trip trip){
        trip.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        tripRepo.save(trip);
    }
    public boolean existById(Long id){
        return tripRepo.existsById(id);
    }
    public void deleteById(Long id){
        tripRepo.deleteById(id);
    }

    public int getSumOfDistance() {
        return ((int) tripRepo.findAll().stream().mapToDouble(Trip::getDistance).sum());
    }

    public int getNumberOfTrips() {
        return ((int) tripRepo.count());
    }
}
