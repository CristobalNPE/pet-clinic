package me.cnpe.petclinic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "health_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HealthHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Date date;

  private String illness;

  private String treatment;

}
