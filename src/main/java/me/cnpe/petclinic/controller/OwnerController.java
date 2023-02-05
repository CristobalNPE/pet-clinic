package me.cnpe.petclinic.controller;

import lombok.RequiredArgsConstructor;
import me.cnpe.petclinic.dto.OwnerDto;
import me.cnpe.petclinic.service.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/owners")
@RequiredArgsConstructor
public class OwnerController {

  private final OwnerService ownerService;

  @GetMapping
  public List<OwnerDto> getAllOwners() {
    return ownerService.findAllOwners();
  }

  @PostMapping
  public ResponseEntity<OwnerDto> createOwner(@RequestBody OwnerDto ownerDto) {
    var savedOwner = ownerService.saveOwner(ownerDto);

    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/")
            .buildAndExpand(ownerDto.getRut())
            .toUri();

    return ResponseEntity.created(location).body(savedOwner);

  }

}
