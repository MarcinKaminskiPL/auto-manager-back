package net.mkaminski.autoManagerBackend.thymeleafControllers;

import lombok.RequiredArgsConstructor;
import net.mkaminski.autoManagerBackend.model.entities.Car;
import net.mkaminski.autoManagerBackend.services.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("/cars")
    public String get(Model model) {
        model.addAttribute("cars", carService.getCars());
        model.addAttribute("newCar", new Car());
        model.addAttribute("numberOfCars", carService.numberOfCars());
        model.addAttribute("averageOdometerStatus", carService.getAverageOdometerStatus());
        return "cars";
    }
    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car){
        carService.save(car);
        return "redirect:/cars";
    }
}
