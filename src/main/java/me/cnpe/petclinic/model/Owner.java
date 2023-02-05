package me.cnpe.petclinic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String rut;

  private String name;

  @OneToOne(mappedBy = "owner", cascade = CascadeType.PERSIST)
  private Address address;

  private String phoneNumber;

  private String email;

  @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
  private List<Pet> petsOwned = new ArrayList<>();

  @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
  private List<Appointment> appointmentList = new ArrayList<>();

}
