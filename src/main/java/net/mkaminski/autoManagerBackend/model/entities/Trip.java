package net.mkaminski.autoManagerBackend.model.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long carId;
    private java.sql.Timestamp createdAt;
    private String destination;
    private int distance;
    private String description;
}
