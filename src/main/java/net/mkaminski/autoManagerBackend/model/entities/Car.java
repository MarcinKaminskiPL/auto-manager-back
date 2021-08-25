package net.mkaminski.autoManagerBackend.model.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String mark;
    private String model;
    private String registrationNumber;
    private int odometerstatus;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate deadlineOfAC;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate deadlineOfOC;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate deadlineOfTechnicalInspection;


    @OneToMany
    @JoinColumn(name = "carId")
    private List<Expense> expenses;

    @OneToMany
    @JoinColumn(name = "carId")
    private List<Trip> trips;
}
