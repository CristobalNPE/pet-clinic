package me.cnpe.petclinic.service;

import lombok.RequiredArgsConstructor;
import me.cnpe.petclinic.dto.PetDto;
import me.cnpe.petclinic.dto.PetSlimDto;
import me.cnpe.petclinic.exception.ResourceNotFoundException;
import me.cnpe.petclinic.mapper.OwnerMapper;
import me.cnpe.petclinic.mapper.PetMapper;
import me.cnpe.petclinic.model.Owner;
import me.cnpe.petclinic.model.Pet;
import me.cnpe.petclinic.repository.OwnerRepository;
import me.cnpe.petclinic.repository.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PetService {

  private final PetRepository petRepository;
  private final OwnerRepository ownerRepository;
  private final PetMapper petMapper;
  private final OwnerMapper ownerMapper;


  public List<PetSlimDto> findAllPets() {
    return petRepository.findAll()
            .stream().map(petMapper::toSlimDto)
            .toList();
  }

  public PetDto savePet(PetDto petDto) {
    var petToSave = petMapper.toEntity(petDto);
    var owner = ownerRepository.findByRut(petDto.getOwnerRut());
    owner.ifPresent(petToSave::setOwner);

    return petMapper.toDto(petRepository.save(petToSave));
  }



}
