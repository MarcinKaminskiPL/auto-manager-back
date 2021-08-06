package net.mkaminski.autoManagerBackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String mark;
    private String model;
    private int odometerstatus;

    @OneToMany
    @JoinColumn(name = "carId")
    private List<Expense> expenses;
}
