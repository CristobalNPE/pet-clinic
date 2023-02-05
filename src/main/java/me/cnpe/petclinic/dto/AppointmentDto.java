package me.cnpe.petclinic.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AppointmentDto {

  private Date date;
  private Boolean wasCompleted;
}
