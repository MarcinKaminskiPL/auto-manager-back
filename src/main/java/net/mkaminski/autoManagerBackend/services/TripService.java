package net.mkaminski.autoManagerBackend.services;

import lombok.RequiredArgsConstructor;
import net.mkaminski.autoManagerBackend.model.entities.Trip;
import net.mkaminski.autoManagerBackend.model.repositories.TripRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {
    private final TripRepository tripRepository;

    public List<Trip> getTrips(){
        return tripRepository.findAll();
    }
    public void add(Trip trip){
        trip.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        tripRepository.save(trip);
    }
    public boolean existById(Long id){
        return tripRepository.existsById(id);
    }
    public void deleteById(Long id){
        tripRepository.deleteById(id);
    }

    public int getSumOfDistance() {
        return ((int) tripRepository.findAll().stream().mapToDouble(Trip::getDistance).sum());
    }

    public int getNumberOfTrips() {
        return ((int) tripRepository.count());
    }
}
