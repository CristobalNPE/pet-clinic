package me.cnpe.petclinic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "owner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetOwner {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToOne(mappedBy = "petOwner",cascade = CascadeType.PERSIST)
  private Address address;

  private String phoneNumber;

  private String email;

  @OneToMany(mappedBy = "petOwner", cascade = CascadeType.PERSIST)
  private List<Pet> petsOwned;

  @OneToMany(mappedBy = "petOwner", cascade = CascadeType.PERSIST)
  private List<Appointment> appointmentList;

}
