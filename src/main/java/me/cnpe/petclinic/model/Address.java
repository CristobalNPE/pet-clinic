package me.cnpe.petclinic.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String street;
  private String city;
  private String postalCode;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "owner")
  private Owner owner;

}
