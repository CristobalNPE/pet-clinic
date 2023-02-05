package me.cnpe.petclinic.service;

import lombok.RequiredArgsConstructor;
import me.cnpe.petclinic.dto.OwnerDto;
import me.cnpe.petclinic.exception.DuplicatedResourceException;
import me.cnpe.petclinic.mapper.OwnerMapper;
import me.cnpe.petclinic.model.Address;
import me.cnpe.petclinic.model.Owner;
import me.cnpe.petclinic.repository.AddressRepository;
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
  private final AddressRepository addressRepository;

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

}
