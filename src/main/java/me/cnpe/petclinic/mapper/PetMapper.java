package me.cnpe.petclinic.mapper;

import me.cnpe.petclinic.dto.PetDto;
import me.cnpe.petclinic.dto.PetSlimDto;
import me.cnpe.petclinic.enums.Gender;
import me.cnpe.petclinic.enums.Species;
import me.cnpe.petclinic.model.Pet;
import me.cnpe.petclinic.model.PetOwner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PetMapper {

  @Mapping(target = "healthHistory", ignore = true)
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "gender", source = "gender", qualifiedByName = "fromStringToGender")
  @Mapping(target = "species", source = "species", qualifiedByName = "fromStringToSpecies")
  @Mapping(target = "petOwner", source = "ownerName", qualifiedByName = "ownerNameToOwner")
  Pet toEntity(PetDto dto);

  @Mapping(target = "ownerName", source = "petOwner.name")
  PetSlimDto toSlimDto(Pet pet);

  @Mapping(target = "ownerName", source = "petOwner.name")
  PetDto toDto(Pet pet);


  @Named("ownerNameToOwner")
  default PetOwner fromOwnerNameToOwner(String ownerName) {
    PetOwner petOwner = new PetOwner();
    petOwner.setName(ownerName);
    return petOwner;
  }

  @Named("fromStringToGender")
  default Gender fromStringToGender(String gender) {
    return Gender.valueOf(gender.toUpperCase());
  }

  @Named("fromStringToSpecies")
  default Species fromStringToSpecies(String species) {
    return Species.valueOf(species.toUpperCase());
  }


}
