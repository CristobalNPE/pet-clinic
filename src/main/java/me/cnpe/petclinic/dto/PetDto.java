package me.cnpe.petclinic.dto;

import lombok.Data;

@Data
public class PetDto {

  private String name;
  private String species;
  private String breed;
  private Integer age;
  private String gender;
  private Double weight;
  private String coatColor;

  private String ownerRut;

}
