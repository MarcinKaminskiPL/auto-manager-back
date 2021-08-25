package net.mkaminski.autoManagerBackend.model.entities;

import lombok.Data;
import net.mkaminski.autoManagerBackend.model.PaymentMethod;

import javax.persistence.*;

@Data
@Entity
public class Expense {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long carId;
  private java.sql.Timestamp createdAt;
  private double value;
  private String description;
  @Enumerated(EnumType.ORDINAL)
  private PaymentMethod paymentMethod;

}
