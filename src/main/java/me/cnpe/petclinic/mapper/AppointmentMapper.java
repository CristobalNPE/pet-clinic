package me.cnpe.petclinic.mapper;

import me.cnpe.petclinic.dto.AppointmentDto;
import me.cnpe.petclinic.model.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

  AppointmentDto toDto(Appointment appointment);

}
