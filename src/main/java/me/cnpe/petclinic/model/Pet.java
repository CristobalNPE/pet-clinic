package me.cnpe.petclinic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.cnpe.petclinic.enums.Gender;
import me.cnpe.petclinic.enums.Species;

import java.util.List;

@Entity
@Table(name = "pet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Enumerated(value = EnumType.STRING)
  private Species species;

  private String breed;

  private Integer age;

  @Enumerated(value = EnumType.STRING)
  private Gender gender;

  private Double weight;

  private String coatColor;

  @OneToMany(mappedBy = "pet", cascade = CascadeType.PERSIST)
  private List<HealthHistory> healthHistory;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "owner")
  private Owner owner;


}
