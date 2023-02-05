package me.cnpe.petclinic.dto;

import lombok.Data;

import java.util.List;

@Data
public class OwnerDto {

  private String rut;
  private String name;
  private String addressStreet;
  private String addressCity;
  private String addressPostalCode;
  private String phoneNumber;
  private String email;
//  private List<PetSlimDto> petsOwned;
//  private List<AppointmentDto> appointmentList;

}
