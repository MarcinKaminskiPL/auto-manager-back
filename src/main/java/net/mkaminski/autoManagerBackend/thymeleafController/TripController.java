package net.mkaminski.autoManagerBackend.thymeleafController;

import lombok.RequiredArgsConstructor;
import net.mkaminski.autoManagerBackend.model.Trip;
import net.mkaminski.autoManagerBackend.services.CarService;
import net.mkaminski.autoManagerBackend.services.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TripController {
    private final TripService tripService;

    @GetMapping("/trips")
    public String get(Model model) {
        model.addAttribute("trips", tripService.getTrips());
        model.addAttribute("newTrip", new Trip());
        model.addAttribute("numberOfTrips", tripService.getNumberOfTrips());
        model.addAttribute("sumOfDistance", tripService.getSumOfDistance());
        return "trips";
    }

    @PostMapping("/add-trip")
    public String addTrip(@ModelAttribute Trip trip) {
        // TODO add validation of incoming data
        tripService.add(trip);
        return "redirect:/trips";
    }
}
