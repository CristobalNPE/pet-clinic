package me.cnpe.petclinic.mapper;

import me.cnpe.petclinic.dto.OwnerDto;
import me.cnpe.petclinic.model.Address;
import me.cnpe.petclinic.model.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {PetMapper.class, AppointmentMapper.class})
public interface OwnerMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "petsOwned", ignore = true)
  @Mapping(target = "appointmentList", ignore = true)
  @Mapping(target = "address", source = ".", qualifiedByName = "buildAddress")
  Owner toEntity(OwnerDto ownerDto);

  @Mapping(target = "addressStreet", source = "address.street")
  @Mapping(target = "addressCity", source = "address.city")
  @Mapping(target = "addressPostalCode", source = "address.postalCode")
  OwnerDto toDto(Owner owner);

  @Named("buildAddress")
  default Address fromStringToAddress(OwnerDto ownerDto) {
    return Address
            .builder()
            .street(ownerDto.getAddressStreet())
            .city(ownerDto.getAddressCity())
            .postalCode(ownerDto.getAddressPostalCode())
            .build();
  }


}
