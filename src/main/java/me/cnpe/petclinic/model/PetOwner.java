package me.cnpe.petclinic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pet_owner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetOwner {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToOne
  private Address address;

  private String phoneNumber;

  private String email;

  @OneToMany
  private List<Pet> petsOwned;

  @OneToMany
  private List<Appointment> appointmentList;


}
