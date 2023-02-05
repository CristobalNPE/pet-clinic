package me.cnpe.petclinic.service;

import lombok.RequiredArgsConstructor;
import me.cnpe.petclinic.dto.OwnerDto;
import me.cnpe.petclinic.dto.PetDto;
import me.cnpe.petclinic.exception.DuplicatedResourceException;
import me.cnpe.petclinic.exception.ResourceNotFoundException;
import me.cnpe.petclinic.mapper.OwnerMapper;
import me.cnpe.petclinic.mapper.PetMapper;
import me.cnpe.petclinic.model.Address;
import me.cnpe.petclinic.repository.OwnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OwnerService {

  private final OwnerRepository ownerRepository;
  private final OwnerMapper ownerMapper;
  private final PetMapper petMapper;

  public List<OwnerDto> findAllOwners() {
    return ownerRepository.findAll().stream()
            .map(ownerMapper::toDto)
            .toList();
  }

  public OwnerDto saveOwner(OwnerDto ownerDto) {

    var ownerToSave = ownerMapper.toEntity(ownerDto);

    if (ownerRepository.findByRut(ownerDto.getRut()).isPresent()) {
      throw new DuplicatedResourceException(ownerDto.getRut());
    }

    Address address = ownerToSave.getAddress();
    address.setOwner(ownerToSave);

    return ownerMapper.toDto(ownerRepository.save(ownerToSave));

  }

  public List<PetDto> findAllPetsFromOwner(Long ownerId) {
    var owner = ownerRepository
            .findById(ownerId)
            .orElseThrow(() -> new ResourceNotFoundException(ownerId));

    var petsOwned = owner.getPetsOwned();

    return petsOwned.stream()
            .map(petMapper::toDto)
            .toList();
  }

  public void updateOwner(Long id, OwnerDto ownerDto) {
    var ownerToUpdate = ownerRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(id));

    var updatedInfo = ownerMapper.toEntity(ownerDto);

    ownerToUpdate.setRut(updatedInfo.getRut());
    ownerToUpdate.setName(updatedInfo.getName());
    ownerToUpdate.setAddress(updatedInfo.getAddress());
    ownerToUpdate.setPhoneNumber(updatedInfo.getPhoneNumber());
    ownerToUpdate.setEmail(updatedInfo.getEmail());

    ownerToUpdate
            .getAddress()
            .setOwner(ownerToUpdate);
    //TODO:should check for a @Valid Body request that does not allow Nulls
    ownerRepository.save(ownerToUpdate);
  }

}
